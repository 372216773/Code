package Test;

public class homework2 {
    public static void main(String[] args) {
        Card card = new Card();
        Thread machine = new Thread(card);
        machine.setName("ATM");
        Thread machine1 = new Thread(card);
        machine1.setName("ATM1");
        machine.start();
        machine1.start();
    }
}

class Card extends Thread {
    private static int money = 100000;
    private static boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            getMoney();
        }
    }

    /*
    1.两个线程同时执行run()方法,都进入while循环中,走到getMoney方法中,
    其中有一个抢到锁,另一个就处于blocked阻塞状态,就执行一次代码,完了之后,就释放锁,
    因为还处于循环中,就又与另一个线程又开始抢锁
     */
    public static void getMoney() {
        synchronized (Card.class) {
            if (money < 1000) {
                System.out.println("剩余余额为:" + money + ",不足以取出1000元");
                loop = false;
            } else {
                System.out.println(Thread.currentThread().getName() + "取走了1000元,剩余余额为: " + (money - 1000));
                money -= 1000;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

