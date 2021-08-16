package exit;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();
        //想要主线程可以控制t线程的终止,只要修改loop的值即可,让t线程退出run()方法,从而终止t线程->通知方式
        //主线程休眠10秒后,终止t线程
        Thread.sleep(10000);
        System.out.println("10秒已到......,停止t线程");
        t.setLoop(false);
    }
}

class T extends Thread {
    int count = 0;
    //设置一个控制变量
    boolean loop = true;
    @Override
    public void run() {

        while (loop) {
            //每隔一秒,输出一段话
            System.out.println("妙啊~" + Thread.currentThread().getName() + count++);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
