package package2.ThreadPool.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/*
newFixedThreadPool
固定大小的线程池
 */
public class TestFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger t = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "mmyPool_t" + t.getAndIncrement());
            }
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 1");
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 2");
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " 3");
        });
    }
}
