package package1.ticket;

/*
使用线程售票
 */
public class SellTicket {
    public static void main(String[] args) {
        //采用extends Thread方式
        /*SellTicket1 sellTicket1 = new SellTicket1();
        SellTicket1 sellTicket2 = new SellTicket1();
        SellTicket1 sellTicket3 = new SellTicket1();

        //会出现超卖现象
        sellTicket1.start();
        sellTicket2.start();
        sellTicket3.start();*/

        //采用implements Runnable
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

    @Override
    public void run() {
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

    @Override
    public void run() {
        while (ticket >= 0) {
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