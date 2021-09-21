package package2.synchronize;

public class TestWaitAndSleep {
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "获得锁");
                try {
                    //Thread.sleep(1000);
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待完了");
            }
        }, "t1").start();

        Thread.sleep(500);
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "获得锁");
        }
    }
}
