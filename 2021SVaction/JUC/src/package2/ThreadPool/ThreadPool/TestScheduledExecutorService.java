package package2.ThreadPool.ThreadPool;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutorService {
    public static void main(String[] args) {
        method5();

    }

    private static void method5() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        //获取当前时间;LocalDateTimeJDK8日期操作类,线程安全,时间运算较方便
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //修改时间为本周周四的18:00:00
        LocalDateTime time = now.withHour(18).withMinute(0).withSecond(0).withNano(0).with(DayOfWeek.THURSDAY);
        System.out.println(time);
        //如果是本周周四,加到下周四
        if (now.compareTo(time) > 0) {
            time = time.plusWeeks(1);
        }
        System.out.println(time);

        //initialDelay:  代表当前时间与周四时间差
        long initialDelay = Duration.between(now, time).toMillis();
        //period:   一周的时间间隔
        long period = 1000 * 60 * 60 * 24 * 7;
        pool.scheduleAtFixedRate(() -> {
            System.out.println("周四18:00:00 running......");
        }, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    //schedule(任务,延时时间,时间单位)
    private static void method1() {
        //核心线程数为2
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

        pool.schedule(() -> {
            System.out.println("task1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            System.out.println("task2");
        }, 1, TimeUnit.SECONDS);
    }

    //schedule(任务,延时时间,时间单位)
    private static void method2() {
        //核心线程数为2
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

        pool.schedule(() -> {

            try {
                System.out.println("task1");
                //线程2不会受线程1的影响
                int i = 1 / 0;
            } catch (Exception e) {
                System.out.println("error");
            }
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            System.out.println("task2");
        }, 1, TimeUnit.SECONDS);
    }

    //scheduleAtFixedRate(任务,初始延时时间,任务执行间隔时间,时间单位)
    private static void method3() {
        //核心线程数为2
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(() -> {
            System.out.println("running......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    //scheduleWithFixedDelay(任务,初始延时时间,距上次任务执行完毕后延时时间,时间单位);
    private static void method4() {
        //核心线程数为1
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleWithFixedDelay(() -> {
            System.out.println("running......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    //每周四18:00:00定时执行任务
}
