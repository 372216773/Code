package package2.pattern;

/*
两阶段终止模式
 */
public class TwoPhaseTermination_interrupt {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(3000);
        twoPhaseTermination.stop();
    }
}

class TwoPhaseTermination {
    private Thread monitor;

    /**
     *
     */
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    System.out.println("被打断");
                    System.out.println("料理后事!");
                    break;
                }
                try {
                    /*
                    被打断有两种情况:
                        1.sleep()被打断,会进入到catch代码块,打断标记置为false
                        2.正常语句执行时被中断,打断标记为true
                     */
                    Thread.sleep(1000);
                    System.out.println("正在执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //执行打断指令,此时打断标记被置为true
                    Thread.currentThread().interrupt();
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
