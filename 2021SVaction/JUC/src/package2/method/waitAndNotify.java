package package2.method;

public class waitAndNotify {
    static final Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+"进入到同步代码块中");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"被唤醒了");
            }
        }, "t1").start();

        new Thread(()->{
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+"进入到同步代码块中");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"被唤醒了");
            }
        }, "t2").start();

        new Thread(()->{
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+"进入到同步代码块中");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"被唤醒了");
            }
        }, "t3").start();

        Thread.sleep(1000);
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"拿到锁,调用notify来随机唤醒Waiting中的线程");
            //随即唤醒一个在Monitor对象中Waiting中的线程
            //lock.notify();
            // JVM有很多实现, 比较流行的就是hotspot
            //唤醒所有在Monitor对象中Waiting中的对象
            lock.notifyAll();
            System.out.println("不会立即释放锁,而是将同步代码块执行完,才真正的释放锁");
        }

    }
}
