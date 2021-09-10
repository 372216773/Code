package package2.method;
/*
interrupt打断正常运行线程
 */
public class interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    System.out.println("isInterrupted:  "+ true);
                    System.out.println("退出线程");
                    break;
                }
            }
        },"t1");

        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
