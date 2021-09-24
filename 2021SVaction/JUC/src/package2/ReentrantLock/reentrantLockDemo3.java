package package2.ReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/*
锁超时
 */
public class reentrantLockDemo3 {
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("尝试获得锁");
            if (!reentrantLock.tryLock()) {
                //没有获得锁
                System.out.println("没有等待,获取不到锁,我进行的操作是直接退出");
                return;
            }

            try {
                System.out.println("执行临界区代码......");
            } finally {
                //try中的临界代码执行完了,释放锁
                reentrantLock.unlock();
            }

        }, "t1");

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获得锁");
            try {
                if (!reentrantLock.tryLock(2, TimeUnit.MINUTES)) {
                    //没有获得锁
                    System.out.println(Thread.currentThread().getName() + "等待了两秒,获取不到锁,我进行的操作是直接退出");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "在等待两秒的过程中,被别的线程打断,此时不再等待,让他直接退出");
                return;
            }

            try {
                System.out.println(Thread.currentThread().getName() + "执行临界区代码......");
            } finally {
                //try中的临界代码执行完了,释放锁
                System.out.println(Thread.currentThread().getName() + "try中的临界代码执行完了,释放锁");
                reentrantLock.unlock();
            }

        }, "t2");

        //main线程拿到锁
        reentrantLock.lock();

        //thread线程只要获取不到锁,直接退出
        //thread.start();

        /*
        thread1如果线程获取不到锁,会等待两秒
        1.在等待时间内,获得到锁,运行临界区代码
        2.等待时间内,被别的线程打断,直接退出
        2.超过等待时间,还没有获得锁,直接退出
         */
        thread1.start();

        //主线程过1秒后,释放锁
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "过1秒后,释放锁");
        reentrantLock.unlock();
    }
}
