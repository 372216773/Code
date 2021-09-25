package package2.pattern;

import java.util.concurrent.locks.LockSupport;

/*
同步模式之顺序控制
Wait/Notify版本
 */
public class synchronization_parkAndUnPark {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            //暂停线程运行
            LockSupport.park();
            System.out.println("执行" + Thread.currentThread().getName() + "的代码");
            System.out.println("不管谁先被CPU调度,线程中的代码执行顺序永远都是2-->1");
        }, "t1");

        Thread thread1 = new Thread(() -> {
            //恢复线程运行
            LockSupport.unpark(thread);
            System.out.println("执行" + Thread.currentThread().getName() + "的代码");
        }, "t2");

        thread.start();
        thread1.start();
    }
}
