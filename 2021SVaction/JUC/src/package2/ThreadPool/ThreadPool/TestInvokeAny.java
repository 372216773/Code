package package2.ThreadPool.ThreadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
invokeAny
 */
public class TestInvokeAny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Object o = pool.invokeAny(Arrays.asList(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "...begin");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "...end");
                    return "1";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + "...begin");
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + "...end");
                    return "2";
                },
                () -> {
                    System.out.println(Thread.currentThread().getName() + "...begin");
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "...end");
                    return "3";
                }
        ));
        //线程池中有两个线程,因为线程2先执行完,所以返回结果为线程2的结果,其他线程都被取消,没有执行完
        //线程池中只有一个线程,线程一先执行第一个任务,所以会打印线程1的结果
        System.out.println(o);
    }
}
