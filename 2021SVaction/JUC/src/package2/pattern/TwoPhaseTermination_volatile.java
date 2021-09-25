package package2.pattern;

/*
两阶段终止模式
使用interrupt缺点,就是有两种情况需要考虑,容易遗漏对于sleep时被打断的处理
 */
public class TwoPhaseTermination_volatile {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination1 twoPhaseTermination = new TwoPhaseTermination1();
        twoPhaseTermination.start();
        Thread.sleep(3000);
        twoPhaseTermination.stop();
    }
}

class TwoPhaseTermination1 {
    private Thread monitor;

    //volatile保证可见性
    private volatile boolean stop;

    /**
     *
     */
    public void start() {
        monitor = new Thread(() -> {
            System.out.println(System.currentTimeMillis());
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (stop) {
                    System.out.println("被打断");
                    System.out.println("料理后事!");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("正在执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }

            System.out.println(System.currentTimeMillis());
        });
        monitor.start();
    }

    public void stop() {
        stop = true;
        //避免此时线程正在sleep中,等待过长时间
        monitor.interrupt();
    }
}
