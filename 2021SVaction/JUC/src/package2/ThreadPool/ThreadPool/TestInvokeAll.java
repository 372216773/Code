package package2.ThreadPool.ThreadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
InvokeAll:提交 tasks 中所有任务
 */
public class TestInvokeAll {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        List<Future<String>> futures = pool.invokeAll(Arrays.asList(
                () -> {
                    System.out.println("begin");
                    Thread.sleep(1000);
                    return "1";
                },
                () -> {
                    System.out.println("begin");
                    Thread.sleep(500);
                    return "2";
                },
                () -> {
                    //因为线程池中只有两个线程,所以这个线程会进入阻塞队列中进行等待
                    System.out.println("begin");
                    Thread.sleep(2000);
                    return "3";
                }
        ));
        futures.forEach(f -> {
            try {
                //总共花费2.5秒后执行
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
