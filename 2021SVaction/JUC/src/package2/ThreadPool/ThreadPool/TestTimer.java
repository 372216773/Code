package package2.ThreadPool.ThreadPool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TestTimer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.schedule(() -> {
            try {
                log.debug("task1");
                int i = 1 / 0;
            } catch (Exception e) {
                log.error("error:", e);
            }
        }, 1, TimeUnit.SECONDS);*/

        /*ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            try {
                System.out.println("task1");
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("error:" + e);
            }
        });*/
        method4();
    }

    private static void method3() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        System.out.println("start...");
        pool.scheduleAtFixedRate(() -> {
            System.out.println("running...");
        }, 1, 1, TimeUnit.SECONDS);
    }

    private static void method2(ScheduledExecutorService pool) {
        pool.schedule(() -> {
            System.out.println("task1");
            int i = 1 / 0;
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            System.out.println("task2");
        }, 1, TimeUnit.SECONDS);
    }

    //timer延迟
    private static void method1() {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 2");
            }
        };

        System.out.println("start...");
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }

    //timer错误
    private static void method4() {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 1");
                int i = 1/0;
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("task 2");
            }
        };

        System.out.println("start...");
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }
}