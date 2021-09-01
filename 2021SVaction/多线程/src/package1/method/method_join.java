package package1.method;

/*
join
 */
public class method_join {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        T3 t3 = new T3();
        t3.start();

        t2.setName("华强");
        t2.start();
        for (int i = 0; i < 20; i++) {
            if (i == 5) {
                System.out.println("华强一格核善的眼神(￢︿̫̿￢☆)");
                System.out.println("华强哥先请!");
                t2.join();
                System.out.println("华强走了......");
                System.out.println("华强哥慢走,我再排会队!");
            } else {
                System.out.println("瓜摊老板正在排队......" + i+"/20");
            }
            Thread.sleep(1000);
        }
    }
}

class T2 extends Thread {
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
class T4 extends Thread {
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
