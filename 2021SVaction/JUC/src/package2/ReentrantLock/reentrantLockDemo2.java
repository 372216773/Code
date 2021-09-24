package package2.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/*
可打断
 */
public class reentrantLockDemo2 {
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            System.out.println("尝试获得锁");
            //如果没有竞争,此方法就会获取锁,如果有竞争,就会进入阻塞队列(可以被其他线程用interrupt打断)
            try {
                reentrantLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("没有获得锁");
                System.out.println("等待被打断了,不再等待");
                return;
            }

            /*//如果获得不到锁,就会进入阻塞队列,一直等待锁的释放,无法打断等待
            reentrantLock.lock();*/
            try {
                System.out.println("拿到了锁");
            } finally {
                //释放锁
                reentrantLock.unlock();
            }
        }, "t1");

        //main线程先拿到锁,thread线程拿不到锁,就一直等待
        reentrantLock.lock();
        thread.start();

        Thread.sleep(1000);
        //打断等待
        thread.interrupt();
    }
}
