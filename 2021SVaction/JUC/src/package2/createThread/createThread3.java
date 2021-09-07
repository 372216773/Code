package package2.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class createThread3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Integer返回之类型
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"的call");
                Thread.sleep(3000);
                return 100;
            }
        });

        //为thread线程对象命名
        Thread thread = new Thread(futureTask,"thread");
        //start()调用的是start0(),最后run()什么时候被执行,取决于CPU的调度
        thread.start();

        //get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回
        System.out.println(futureTask.get());
    }
}
