package package2.pattern;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
工作模式
让有限的工作线程来轮流异步处理无限多的任务,经典实现就是    线程池
 */
public class WorkerThread {

    //菜单
    static final List<String> MENU = Arrays.asList("地三鲜", "宫保鸡丁", "辣子鸡丁", "烤鸡翅");

    static Random RANDOM = new Random();

    //随机挑一个要做的菜
    static String cooking() {
        return MENU.get(RANDOM.nextInt(MENU.size()));
    }

    public static void main(String[] args) {
        ExecutorService waiterPool = Executors.newFixedThreadPool(1);
        ExecutorService cookPool = Executors.newFixedThreadPool(1);

        waiterPool.execute(() -> {
            //任务1-->waitPool的thread1完成
            System.out.println(Thread.currentThread().getName() + "处理点餐...");

            //任务2-->cookPool的Thread1完成
            Future<String> f = cookPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "做菜");
                return cooking();
            });
            try {
                System.out.println(Thread.currentThread().getName()+"等待上菜...因为调用了get(),被阻塞住了");
                System.out.println(Thread.currentThread().getName() + "上菜: " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        waiterPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "处理点餐...");
            Future<String> f = cookPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "做菜");
                return cooking();
            });
            try {
                System.out.println(Thread.currentThread().getName()+"等待上菜...因为调用了get(),被阻塞住了");
                System.out.println(Thread.currentThread().getName() + "上菜: " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
