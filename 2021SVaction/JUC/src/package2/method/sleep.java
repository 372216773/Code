package package2.method;

import java.util.concurrent.TimeUnit;
/*

    使此线程休眠2秒

    1. Thread.sleep(2000);

    2. TimeUnit.SECONDS.sleep(2); //单位:秒 睡眠2秒 ,直观,可读性好
 */
public class sleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                try {
                    //Thread.sleep(2000);
                    //单位:秒 睡眠2秒 ,直观
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        System.out.println(thread.getState());

        //Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.getState());

        //Thread.sleep(1000);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.getState());
    }
}
