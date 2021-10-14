package package2.ThreadPool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
SingleThreadExecutor
单线程执行器
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test2() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(() -> {
            System.out.println("1");
            //出异常,并不会结束执行,SingleThread会创建一个新线程，继续执行任务队列中剩余的任务。
            int i = 1 / 0;
        });

        pool.execute(() -> {
            System.out.println("2");
        });

        pool.execute(() -> {
            System.out.println("3");
        });
    }

    private static void test1() {
        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger t = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "mypool_t" + t.getAndIncrement());
            }
        });

        pool.execute(() -> {
            System.out.println("1");
        });

        pool.execute(() -> {
            System.out.println("2");
        });

        pool.execute(() -> {
            System.out.println("3");
        });
    }
}
