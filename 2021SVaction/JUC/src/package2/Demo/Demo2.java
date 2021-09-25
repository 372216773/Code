package package2.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
循环输出
abc
输出5次
可以同一个整数标记来判断执行那个线程
AwaitSignal版
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition condition1 = awaitSignal.newCondition();
        Condition condition2 = awaitSignal.newCondition();
        Condition condition3 = awaitSignal.newCondition();

        new Thread(() -> {
            awaitSignal.print("a", condition1, condition2);
        }, "t1").start();
        new Thread(() -> {
            awaitSignal.print("b", condition2, condition3);
        }, "t2").start();
        new Thread(() -> {
            awaitSignal.print("c", condition3, condition1);
        }, "t3").start();

        //让三个线程全都进入各自的WaitSet中等待
        Thread.sleep(1000);
        //要先获得锁
        try {
            //临界区代码
            awaitSignal.lock();
            //调用对应的条件变量,使得t1线程从条件变量中苏醒,进入阻塞队列
            condition1.signal();
        } finally {
            //释放锁,t1线程拿到锁
            awaitSignal.unlock();
        }
    }
}

class AwaitSignal extends ReentrantLock {

    private final int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * 打印字符串
     *
     * @param str     字符串
     * @param current 当前线程的条件变量(当前线程进入等待)
     * @param next    下一个线程对应的条件变量(唤醒这个条件变量中的线程)
     */
    public void print(String str, Condition current, Condition next) {
        //继承自ReentrantLock的方法
        for (int i = 0; i < loopNumber; i++) {
            //获得锁,其他线程在阻塞队列中等待锁的释放
            lock();
            try {
                //进入current的conditionObject中进行等待,并释放锁
                try {
                    current.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //拿到锁就向下执行
                //执行打印操作
                System.out.print(str);
                //唤醒在在next的conditionObject中等待的线程,进入阻塞队列,等待锁的释放
                next.signal();
            } finally {
                //释放锁
                unlock();
            }
        }
    }
}
