package Demo3.Runnable.Demo1;
/*
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        MyThread myThread=new MyThread();
//        Thread thread=new Thread(myThread);
//        thread.start();
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("main--"+i);
//        }


        MyThread1 myThread1=new MyThread1();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(myThread1);
        Thread thread=new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());

    }

}
