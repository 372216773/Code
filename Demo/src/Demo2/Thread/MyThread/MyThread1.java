package Demo2.Thread.MyThread;

public class MyThread1 extends Thread{

    public boolean isRunning=true;

    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean running){
        isRunning=running;
    }

    public MyThread1(String threadName){
        super(threadName);
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(getName()+"--"+i);

        }
    }



}
