package package2.ThreadPool.ThreadPool;

import java.util.concurrent.SynchronousQueue;

/*
带缓冲的线程池
newCachedThreadPool
 */
public class TestCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<Integer> integers = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println("putting" + 1);
                integers.put(1);
                System.out.println("putted..." + 1);

                System.out.println("putting..." + 2);
                integers.put(2);
                System.out.println("putted..." + 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        Thread.sleep(2000);

        new Thread(() -> {
            try {
                System.out.println("taking" + 1);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

        Thread.sleep(2000);

        new Thread(() -> {
            try {
                System.out.println("taking" + 2);
                integers.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3").start();

    }
}
