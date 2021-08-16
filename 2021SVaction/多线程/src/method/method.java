package method;
/*
interrupt
 */
public class method {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("打工人");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("已经过了" + i + "秒");
        }
        //interrupt是终端休眠的
        t.interrupt();

    }
}

class T extends Thread {
    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "干活干活~" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println(Thread.currentThread().getName() + "开始休眠......");
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                //当该线程执行到interrupt方法时,catch就会捕获到一个异常
                System.out.println(Thread.currentThread().getName() + "睡得好好的,睡10秒,被中断了,开始工作......");
            }
        }
    }
}
