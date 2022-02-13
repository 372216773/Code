package package2.JUC;

import java.util.concurrent.Semaphore;
/*
Semaphore:  限制线程数
 */
public class TestSemaphore {
    public static void main(String[] args) {
        // 1.   创建Semaphore对象
        // 1.permits(许可):同一时刻最大访问数量,超过就会阻塞住;fair(公平/非公平)
        Semaphore semaphore = new Semaphore(3);

        // 2.创建10个线程同时运行
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    //1.获得许可(可用许可数-1)
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " running......");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " end......");
                } finally {
                    //释放许可(可用许可数+1)
                    semaphore.release();
                }
            }).start();
        }
    }
}