package package2.method;
/*
yield:让出
 */
public class yield {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "-->" + count++);
                }
            }
        };

        //
        Runnable runnable1 = () -> {
            int count = 0;
            //此线程让出CPU的使用权限
            Thread.yield();
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "->" + count++);
                }
        };

        Thread thread = new Thread(runnable, "runnable1");
        Thread thread1 = new Thread(runnable1, "runnable2");

        thread.start();
        thread1.start();
    }
}
