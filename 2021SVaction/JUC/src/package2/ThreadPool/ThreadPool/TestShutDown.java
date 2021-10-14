package package2.ThreadPool.ThreadPool;

import java.util.List;
import java.util.concurrent.*;

public class TestShutDown {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = pool.submit(() -> {
            System.out.println("task 1 running...");
            Thread.sleep(1000);
            System.out.println("task 1 finish...");
            return 1;
        });

        Future<Integer> result2 = pool.submit(() -> {
            System.out.println("task 2 running...");
            Thread.sleep(1000);
            System.out.println("task 2 finish...");
            return 2;
        });

        Future<Integer> result3 = pool.submit(() -> {
            System.out.println("task 3 running...");
            Thread.sleep(1000);
            System.out.println("task 3 finish...");
            return 3;
        });

        System.out.println("shutdown");
        //并不会取消正在执行的任务,也不会影响到已经提交到队列中的任务
        pool.shutdown();
        /*
        会报错 RejectedExecutionException ,不允许再添加新任务
            pool.submit(() -> {
            System.out.println("task 4 running...");
            Thread.sleep(1000);
            System.out.println("task 4 finish...");
            return 4;
        });*/
        //不会阻塞调用线程的执行
        //System.out.println("other......");
        pool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("other......");
/*        List<Runnable> runnables = pool.shutdownNow();
        System.out.println("other...." + runnables);*/
    }
}
