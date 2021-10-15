package package2.ThreadPool.ThreadPool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class TestTimer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method1();
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
    private static void method2() {
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