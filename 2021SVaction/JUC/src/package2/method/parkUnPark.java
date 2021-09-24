package package2.method;

import java.util.concurrent.locks.LockSupport;

public class parkUnPark {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("start......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("park......进入wait状态");
            //暂停线程的运行
            LockSupport.park();
            System.out.println("resume......");
        }, "t1");
        thread.start();

        Thread.sleep(1000);
        System.out.println("UnPark......");
        //恢复指定线程
        LockSupport.unpark(thread);
    }
}
