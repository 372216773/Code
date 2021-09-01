package package1.method;

/*
yield
 */
public class method_yield {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.setName("person1");
        t2.start();
        for (int i = 0; i < 20; i++) {
            if (i == 5) {
                t2.yield();
                System.out.println("看了看CPU(排队)暂时不太紧张,那就不让了/稍微让一点");
            }
                System.out.println("person2正在排队......" + i+"/20");
            Thread.sleep(1000);
        }
    }
}

class T3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()  + "正在排队中......"+ i+"/20");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
