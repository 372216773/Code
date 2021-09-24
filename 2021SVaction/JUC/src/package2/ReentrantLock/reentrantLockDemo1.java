package package2.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;
/*
可重入
 */
public class reentrantLockDemo1 {
    //之前都是java对象关联一个(Monitor)锁对象,现在这个reentrantLock就是锁对象
    private static final ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        //加锁
        reentrantLock.lock();
        m2();
        try{
            System.out.println("临界区代码1");
        } finally {
            //解锁
            reentrantLock.unlock();
        }
    }
    private static void m2() {
        //加锁
        reentrantLock.lock();

        try{
            System.out.println("临界区代码2");
        } finally {
            //解锁
            reentrantLock.unlock();
        }
    }
}
