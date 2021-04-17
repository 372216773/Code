package Demo3.Runnable.Demo1;

public class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread1--"+i);
        }
    }
}
