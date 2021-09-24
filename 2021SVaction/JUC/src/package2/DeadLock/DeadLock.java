package package2.DeadLock;

public class DeadLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(()->{
            synchronized (A) {
                System.out.println(Thread.currentThread().getName()+"拿到A锁,进入到A的同步代码块");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(B) {
                    System.out.println(Thread.currentThread().getName()+"拿到B锁,进入到B的同步代码块");
                }
            }
        },"t1").start();

        new Thread(()->{
            synchronized (B) {
                System.out.println(Thread.currentThread().getName()+"拿到B锁,进入到B的同步代码块");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(A) {
                    System.out.println(Thread.currentThread().getName()+"拿到A锁,进入到A的同步代码块");
                }
            }
        },"t2").start();
    }
}