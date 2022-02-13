package package2.ThreadPool.ThreadPool.MyPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.MILLISECONDS, 10, (queue, task) -> {
            //1.死等
            //queue.put(task);
            //2.带超时的等待
            //queue.offer(task,1000,TimeUnit.MILLISECONDS);
            //3.放弃执行任务
            //System.out.println("放弃执行任务");
            //4.抛出异常(剩余任务就不会执行)
            //throw new RuntimeException("任务执行失败"+task);
            //5.让调用者自己执行任务
            System.out.print(Thread.currentThread().getName() + "线程执行...");
            task.run();
        });
        for (int i = 0; i < 15; i++) {
            //
            int temp = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(temp);
            });
        }
    }
}


//可使用lambda表达式
@FunctionalInterface
//拒绝策略
interface RejectPolicy<T> {
    /**
     * @param queue 队列(判断是否满)
     * @param task  任务(具体任务的操作)
     */
    void reject(BlockingQueue<T> queue, T task);
}

//线程池
class ThreadPool {
    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;

    //获取任务的超时时间(超过一段时间还没有任务,线程结束)
    private long timeout;

    //转换时间
    private TimeUnit timeUnit;

    //
    private RejectPolicy<Runnable> rejectPolicy;

    //执行任务
    public void execute(Runnable task) {
        //防止多个线程执行一个任务,出线程安全问题
        synchronized (workers) {
            //当任务数没有超过coreSize时,直接创建新的worker对象,交给worker对象执行
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                System.out.println("任务数少于coreSize时,创建新的worker对象执行任务,worker" + worker);
                //加入到线程集合中
                workers.add(worker);
                //执行线程
                worker.start();
            } else {
                //当任务数大于等于coreSize时
                //taskQueue.put(task);

                //策略模式:具体的操作抽象为一个接口,具体的实现由调用者实现
                //1).死等
                //2).带超时等待
                //3).调用者放弃任务执行
                //4).调用者抛出异常
                //5).调用者执行任务
                //封装到taskQueue,因为有Reentrant锁,可以保证方法的安全
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapacity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapacity);
        this.rejectPolicy = rejectPolicy;
    }

    class Worker extends Thread {
        //接收任务
        private Runnable task;

        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            //1)当task不为空时,执行任务
            //2)当task执行完毕,再接着从taskQueue中获取任务对象,执行任务
            while (task != null || ((task = taskQueue.poll(timeout, timeUnit)) != null)) {
                try {
                    System.out.println(Thread.currentThread() + getName() + "正在执行任务" + task);
                    //执行task任务
                    task.run();
                } catch (Exception e) {
                    //执行任务可能会出现异常
                    System.out.println(Thread.currentThread() + getName() + "正在执行任务" + task);
                } finally {
                    //任务执行完毕,使任务为空,以便接受新的任务
                    task = null;
                }
            }
            //synchronized (workers) {
            System.out.println(Thread.currentThread().getName() + "移除worker:    " + this);
            //将这个线程移除(已经没有任务执行了)
            workers.remove(this);
            //}
        }
    }
}

//阻塞队列
class BlockingQueue<T> {
    //1.任务队列(先进先出的双向链表),ArrayDeque性能优于LinkedList
    private Deque<T> deque = new ArrayDeque<>();

    //2.锁
    // 避免多个线程同时获取同一任务,同一任务只能有一个线程执行,其他线程等待
    //避免多个线程同时往任务队列中添加任务,同一时刻只能有一个线程添加任务
    private ReentrantLock lock = new ReentrantLock();

    //3.生产者条件变量(阻塞时进入条件变量等待)
    private Condition fullWaitSet = lock.newCondition();

    //4.消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    //5.容量
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 6.从阻塞队列中获取任务
     * @return 任务
     */
    public T take() {
        //获得锁
        lock.lock();
        try {
            //队列为空,take()进入阻塞状态,进入条件变量进行等待
            while (deque.isEmpty()) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //拿到任务
            T t = deque.removeFirst();
            //在这时添加任务的线程可能因为队列已满,处于等待状态,所以需要唤醒
            fullWaitSet.signal();
            return t;
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    /**
     * 带超时的阻塞获取,不会无限制等待.(TimeUnit可以进行时间转换)
     * @param timeout 超时时间
     * @param unit 统一时间单位
     * @return 返回获取的任务
     */
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        try {
            //将timeout统一转换为纳秒
            long nanos = unit.toNanos(timeout);
            while (deque.isEmpty()) {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    //返回的是剩余时间(timeout - 等待此方法执行完所花费的时间)
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //获取任务
            T t = deque.removeFirst();
            //这时队列就有空位,唤醒因为队列已满进入等待状态的线程
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 7.往阻塞队列中添加任务
     * @param task 任务
     */
    public void put(T task) {
        lock.lock();
        try {
            //队列已满,进入阻塞状态
            while (deque.size() == capacity) {
                try {
                    System.out.println("当任务数大于等于coreSize时,使任务等待加入任务队列" + task);
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //添加任务
            deque.addLast(task);
            System.out.println("当任务数大于等于coreSize时,使任务进入任务队列中" + task);
            //在这时获取任务的线程可能因为队列为空处于等待状态,所以需要唤醒
            emptyWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 带超时时间的阻塞添加
     * @param task 任务
     * @param timeout 超时时间
     * @param timeUnit 统一单位
     * @return 是否添加成功
     */
    public boolean offer(T task, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            //队列已满
            while (deque.size() == capacity) {
                try {
                    System.out.println("当任务数大于等于coreSize时,使任务等待加入任务队列" + task);
                    if (nanos <= 0) {
                        //不再添加任务,直接返回false
                        return false;
                    }
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //添加任务
            deque.addLast(task);
            System.out.println("当任务数大于等于coreSize时,使任务进入任务队列中" + task);
            //在这时获取任务的线程可能因为队列为空处于等待状态,所以需要唤醒
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 8.获取队列大小
     * @return 队列大小
     */
    public int size() {
        lock.lock();
        try {
            return capacity;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 当任务数大于等于coreSize时,对任务的处理
     * @param rejectPolicy 策略
     * @param task 任务
     */
    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (deque.size() == capacity) {
                rejectPolicy.reject(this, task);
            } else {
                System.out.println("加入任务队列");
                deque.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
