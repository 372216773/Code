package package2.ThreadPool.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {
    public static void main(String[] args) {
        //默认线程数是CPU核数
        ForkJoinPool pool = new ForkJoinPool(4);
        //invoke()执行任务
        System.out.println(pool.invoke(new MyTask1(1, 5)));

        //我们要对任务进行拆分
        // new MyTask(5) --> 5 + new MyTask(4) --> 4 + new MyTask(3) --> 3 + new MyTask(2) --> 2 + new MyTask(1)
    }
}


/*
任务对象
有返回值,返回值为Integer: RecursiveTask<Integer>
无返回值: recursiveAction
 */
//1~n求和
class MyTask extends RecursiveTask<Integer> {
    private int n;

    public MyTask(int n) {
        this.n = n;
    }


    //做任务的拆分
    @Override
    protected Integer compute() {
        // 如果 n 已经为 1，可以求得结果了
        if (n == 1) {
            System.out.println(Thread.currentThread().getName() + " - join(" + n + ")");
            return n;
        }

        // 将任务进行拆分(fork)
        MyTask t1 = new MyTask(n - 1);
        //fork()交给一个线程去执行这个任务
        t1.fork();
        System.out.println(Thread.currentThread().getName() + " - fork(" + n + ") + " + t1);

        //join()获取任务的结果
        // 合并(join)结果
        int result = n + t1.join();
        System.out.println(Thread.currentThread().getName() + " - join(" + n + ") + " + t1 + " = " + result);
        return result;
    }

    @Override
    public String toString() {
        return "{" + n + '}';
    }
}

class MyTask1 extends RecursiveTask<Integer> {
    int begin;
    int end;

    public MyTask1(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{" + begin + "," + end + '}';
    }

    @Override
    protected Integer compute() {
        // 5, 5
        if (begin == end) {
            System.out.println("join() " + begin);
            return begin;
        }
        // 4, 5
        if (end - begin == 1) {
            System.out.println("join() " + begin + " + " + end + " = " + (end + begin));
            return end + begin;
        }

        // 1 5
        int mid = (end + begin) / 2; // 3
        MyTask1 t1 = new MyTask1(begin, mid); // 1,3
        t1.fork();
        MyTask1 t2 = new MyTask1(mid + 1, end); // 4,5
        t2.fork();
        System.out.println("fork() " + t1 + " + " + t2 + " = ?");
        int result = t1.join() + t2.join();
        System.out.println("join() " + t1 + " + " + t2 + " = " + result);
        return result;
    }
}

