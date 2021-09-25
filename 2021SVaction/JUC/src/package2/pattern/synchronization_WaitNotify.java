package package2.pattern;

/*
同步模式之顺序控制
Wait/Notify版本
 */
public class synchronization_WaitNotify {
    static final Object object = new Object();
    static boolean flag = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获得锁......");
                //flag为false,这个线程进入等待
                while (!flag) {
                    try {
                        //调用锁对象的wait()
                        System.out.println(Thread.currentThread().getName() + "开始等待......");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + "结束等待,执行代码");
                System.out.println("执行" + Thread.currentThread().getName() + "代码......");
                System.out.println("执行完代码");
            }
        }, "t1");

        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获得锁......");
                System.out.println("执行" + Thread.currentThread().getName() + "代码......");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完代码");
                System.out.println(Thread.currentThread().getName() + "为thread线程放行,调用锁对象的notify,唤醒线程");
                //为thread线程放行
                flag = true;
                //调用锁对象的notify,唤醒线程
                object.notify();
            }
        }, "t2");

        //此时的顺序一定是2-->1
        thread.start();
        thread1.start();
    }
}
