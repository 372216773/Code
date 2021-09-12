package package2.synchronize;

public class Demo {

    public static int count = 0;
    //任意对象都可以作为锁,对象不能为空
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        }, "t1");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        }, "t2");

        thread.start();
        thread1.start();
        //主线程等待调用的线程结束,再去执行其他线程
        thread.join();
        thread1.join();
        System.out.println(count);
    }
}

