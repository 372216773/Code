package package2.createThread;

public class createThread2 {
    public static void main(String[] args) {

        //任务对象
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"的run()......");
            }
        };

        Runnable runnable1 = () -> {
            System.out.println(Thread.currentThread().getName()+"的run()......");
        };

        //线程对象
        Thread thread = new Thread(runnable,"thread");
        Thread thread1 = new Thread(runnable1,"thread");
        thread.start();
        thread1.start();
    }
}
