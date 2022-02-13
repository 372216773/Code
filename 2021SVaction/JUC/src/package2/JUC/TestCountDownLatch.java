package package2.JUC;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        Random random = new Random();
        String[] players = new String[10];

        for (int i = 0; i < 10; i++) {
            int k = i;
            pool.submit(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    players[k] = j + "%";
                    //  \r 代表不换行输出(替换之前的输出)
                    System.out.print("\r" + Arrays.toString(players));
                }
                //循环结束(加载完成),计数 - 1
                latch.countDown();
            });
        }

        latch.await();
        System.out.println("\n欢迎来到召唤师峡谷");
    }

    private static void method1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end");
        }, "t1").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end");
        }, "t2").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end");
        }, "t3").start();

        System.out.println(Thread.currentThread().getName() + " waiting......");
        //等待其他线程执行完(计数)
        latch.await();
        System.out.println(Thread.currentThread().getName() + "wait end");
    }

    //配合线程池,使用CountDownLatch
    private static void method2() {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService pool = Executors.newFixedThreadPool(4);
        pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end; latch: " + latch.getCount());
        });
        pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end; latch: " + latch.getCount());
        });
        pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " begin...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //计数 - 1
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end; latch: " + latch.getCount());
        });

        pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " waiting....");
            //等待计数为0
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait end");
        });
    }
}
