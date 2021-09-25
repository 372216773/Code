package package2.Demo;

/*
循环输出
abc
输出5次
可以同一个整数标记来判断执行那个线程
WaitNotify版
 */
public class Demo1 {
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1,5);

        new Thread(()->{
            waitNotify.print("a",1,2);
        },"t1").start();
        new Thread(()->{
            waitNotify.print("b",2,3);
        },"t1").start();
        new Thread(()->{
            waitNotify.print("c",3,1);
        },"t1").start();

    }
}

class WaitNotify {
    //等待标记
    private int flag;
    //循环次数
    private final int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(String str, int waitFlag, int nextFlag) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                //切换线程
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
