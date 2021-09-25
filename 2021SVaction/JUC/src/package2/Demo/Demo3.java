package package2.Demo;

import java.util.concurrent.locks.LockSupport;

/*
循环输出
abc
输出5次
可以同一个整数标记来判断执行那个线程
park unPark版
 */
public class Demo3 {
    static Thread thread;
    static Thread thread1;
    static Thread thread2;
    public static void main(String[] args) {
        ParkUnPark parkUnPark = new ParkUnPark(5);
        thread = new Thread(() -> {
            parkUnPark.print("a",thread1);
        }, "t1");
        thread1 = new Thread(() -> {
            parkUnPark.print("b",thread2);
        }, "t2");
        thread2 = new Thread(() -> {
            parkUnPark.print("c",thread1);
        }, "t3");
        thread.start();
        thread1.start();
        thread2.start();
        //恢复线程
        LockSupport.unpark(thread);
    }

}

class ParkUnPark {
    private final int loopNumber;

    public ParkUnPark(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    /**
     * park会暂停当前线程,unpark会唤醒指定线程
     * @param str 字符串
     * @param next 指定线程
     */
    public void print(String str, Thread next) {
        for (int i = 0; i < loopNumber; i++) {
            //暂停当前线程
            LockSupport.park();
            //被别的线程恢复后
            System.out.print(str);
            //唤醒下一个线程
            LockSupport.unpark(next);
        }
    }
}

