package package2.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
实现一个不可重入的阻塞式锁
 */
public class TestAQS {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(() -> {
            myLock.lock();
            //不可重复加锁
            // myLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is locking......");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " is unlocking......");
                myLock.unlock();
            }
        }, "t1").start();

        /*new Thread(() -> {
            myLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is locking......");
            } finally {
                System.out.println(Thread.currentThread().getName() + " is unlocking......");
                myLock.unlock();
            }
        }, "t2").start();*/
    }
}

//实现不可重入锁
/*
    1.作为锁的类要实现Lock接口-->锁的相关方法
    2.使用到AQS同步器类-->是阻塞式锁的框架
 */
class MyLock implements Lock {

    //同步器类,实现独占锁
    class MySync extends AbstractQueuedSynchronizer {

        //尝试获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            //保证state修改的的原子性
            if (compareAndSetState(0, 1)) {
                //加上了锁,0-->1,并设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        //尝试释放锁
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            //0:表示解锁,volatile加写屏障,避免重排序
            setState(0);
            return true;
        }

        //是否持有独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    //加锁(不成功,会放入等待队列中等待)
    @Override
    public void lock() {
        //不成功会进入等待队列
        sync.acquire(1);
    }

    //加锁(可打断)
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    //尝试加锁(只会尝试一次)
    @Override
    public boolean tryLock() {
        //只会尝试一次,,成功返回true,失败返回false
        return sync.tryAcquire(1);
    }

    //带超时的加锁
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    //解锁
    @Override
    public void unlock() {
        //调用了修改tryRelease,state为0,owner为null,还会唤醒正在阻塞的线程
        sync.release(1);
    }

    //创建条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}