package package1.State;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("ThreadState: ");
        System.out.println(t.getName() + t.getState());
        t.start();
        System.out.println(t.getName() + t.getState());
        while (t.getState() != Thread.State.TERMINATED) {
            System.out.println(t.getName() + t.getState());
            Thread.sleep(500);
        }
        System.out.println(t.getName() + t.getState());
    }
}

class T extends Thread {
    @Override
    public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("芜湖" + i );
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
