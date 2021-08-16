package syn;

/*
使用线程售票
 */
public class SellTicket {
    public static void main(String[] args) {
        //1.采用extends Thread方式
        /*SellTicket1 sellTicket1 = new SellTicket1();
        SellTicket1 sellTicket2 = new SellTicket1();
        SellTicket1 sellTicket3 = new SellTicket1();
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();*/
        //2.采用implements Runnable
        /*SellTicket2 sellTicket2 = new SellTicket2();
        Thread thread = new Thread(sellTicket2);
        Thread thread1 = new Thread(sellTicket2);
        Thread thread2 = new Thread(sellTicket2);
        thread.start();
        thread1.start();
        thread2.start();*/
        //都会出现超卖现象

        SellTicket2 sellTicket2 = new SellTicket2();
        Thread thread = new Thread(sellTicket2);
        Thread thread1 = new Thread(sellTicket2);
        Thread thread2 = new Thread(sellTicket2);
        thread.start();
        thread1.start();
        thread2.start();


    }
}

class SellTicket1 extends Thread {
    //多个线程共享ticket
    private static int ticket = 50;

    //synchronized设置为同步方法,在同一时刻只能有一个线程来执行这个run()方法
    @Override
    public synchronized void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("窗口:" + Thread.currentThread().getName() + "售出了一张票" + ",剩余票数:" + (--ticket));
        }
        System.out.println("票已售完!");
    }
}

class SellTicket2 implements Runnable {
    //
    private int ticket = 50;
    private boolean loop = true;
    Object object = new Object();

    /*
     public synchronized void sell(){}就是一个同步方法,锁在对象上
     public synchronized static void method () {}
     在非静态方法中
     synchronized (this) {}/synchronized (Object) {}在代码块上加锁,锁是加在对象上,这个对象可以是this,也可以是其他对象,但必须要保证一点,就是这多个线程操作的是同一个对象
     在静态方法中
     synchronized (SellTicket2.class) {}在代码块上加锁,锁是加在类上的
     */

    //synchronized设置为同步方法,在同一时刻只能有一个线程来执行这个run()方法
    public /*synchronized*/ void sell() {

        synchronized (object) {
            if (ticket == 0) {
                System.out.println("票已售罄");
                loop = false;
                return;
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "售出了一张票" + "剩余" + --ticket + "张票!");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}