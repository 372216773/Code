package package2.createThread;

public class createThread1 {
    public static void main(String[] args) {
        Thread thread = new Thread("Thread1") {
            @Override
            public void run() {
                //能直接通过this得到线程的name,是因为Thread类中有name属性
                System.out.println(this.getName()+"的run()......");
            }
        };

        thread.start();

        System.out.println(Thread.currentThread().getName()+"......");
    }
}
