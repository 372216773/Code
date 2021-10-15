package package2.ThreadPool.ThreadPool;

import java.util.concurrent.*;

/*
提交任务
submit()返回有结果的任务
future.get()获取返回结果
 */
public class TestSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);

        Future<Boolean> task = pool.submit(() -> {
            System.out.println("task");
            try {
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("error");
            }
            return true;
        });

        //会阻塞住,等待结果的返回
        System.out.println(task.get());
    }

    private static void method1() throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<String> future = pool.submit(() -> {
            System.out.println("running");
            Thread.sleep(1000);
            //返回"ok",并唤醒主线程
            return "ok";
        });

        //get()阻塞,等待返回的结果
        System.out.println(future.get());
    }
}
