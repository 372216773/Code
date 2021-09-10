package package2.method;

public class DaemonTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + "正在运行中......");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "运行结束......");
        }, "t1");

        //默认为false
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "运行结束......");
    }
}
