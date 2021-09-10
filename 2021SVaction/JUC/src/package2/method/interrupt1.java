package package2.method;
/*
interrupt打断阻塞线程
 */
public class interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("enter sleep()......");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("break sleep......");
                }
            }
        };

        thread.start();
        Thread.sleep(500);
        //使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException,打断标志会设置为false
        //打断正常线程,会使得打断的标记会被置为true
        thread.interrupt();

    }
}
