package package1.thread;
//守护线程setDaemon
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        T4 t4 = new T4();
        //开启守护线程,当其他线程都结束的时候,自动结束
        t4.setDaemon(true);
        t4.start();
        for (int i = 10; i > 0; i--) {
            System.out.println("还有"+i+"秒下班");
            Thread.sleep(1000);
        }
        System.out.println("下班了");
    }
}

class T4 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("打工打工......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}