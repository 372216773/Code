package package2.JUC;

import java.util.concurrent.*;

public class TestCyclicBarri {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //采用CountDownLatch,只创建一个CountDownLatch不能实现多次提交任务的计数效果
        //method1(pool);
        //使用CyclicBarri,只创建一个CyclicBarri对象,计数会被重置,可以达到多次提交任务的计数效果
        method2(pool);

    }

private static void method2(ExecutorService pool) {
        //下次再次调用时,计数会被重置
        //线程数与任务数保持一致
        //CyclicBarrier barrier = new CyclicBarrier(2);

        //通过一个任务来汇总之前的任务的结果
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {
            //执行的时机:其他任务都执行完成
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task1,task2 finish...");
        });

        for (int i = 0; i < 3; i++) {
            pool.submit(() -> {
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task1 begin...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //计数 - 1,2 - 1 = 1, 计数不为零, 线程就会阻塞住
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            pool.submit(() -> {
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task2 begin...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    //计数 - 1, 1 - 1 = 0, 计数减为零,阻塞的线程都会继续向下运行
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
    }

    //没有预期的效果
    private static void method1(ExecutorService pool) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        for (int i = 0; i < 3; i++) {

            pool.submit(() -> {
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task1 begin...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task1 end");
            });
            pool.submit(() -> {
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task2 begin...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " task2 end");
            });
            latch.await();
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " waiting end");
        }
        pool.shutdown();
    }
}
