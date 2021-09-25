package package2.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
条件变量
 */
public class reentrantLockDemo4 {
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        //创建条件变量
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();

        //获得锁
        reentrantLock.lock();

        //会释放锁,进入condition1的conditionObject 中进入等待
        condition1.await();

        //唤醒某个线程
        condition1.signal();

        //唤醒所有线程
        condition1.signalAll();
    }
}
