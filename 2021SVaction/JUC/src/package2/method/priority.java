package package2.method;

/*
Priority
 */
public class priority {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int count = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + "->" + count++);
            }
        };

        Runnable runnable1 = () -> {
            int count = 0;
            while (true) {
                System.out.println(Thread.currentThread().getName() + "->" + count++);
            }
        };

        Thread thread = new Thread(runnable, "runnable");
        Thread thread1 = new Thread(runnable1, "runnable1");

        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
    }
}
