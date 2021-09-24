package package2.pattern;

/*
同步模式之顺序控制
Wait/Notify版本
 */
public class Test2 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "t1");

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "t2");

        //不加控制,被CPU调度的次序是不确定的
        /*thread.start();
        thread1.start();*/
    }
}
