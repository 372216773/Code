package package2.method;

public class interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("enter sleep()......");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("break sleep......");
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        Thread.sleep(500);
        //使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException
        thread.interrupt();

    }
}
