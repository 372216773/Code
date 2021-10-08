package package2.atomic.longAddr;

import java.util.concurrent.atomic.AtomicInteger;
/*
模拟cas锁
 */
public class LockCas {

    //0:没加锁 1:加锁
    private AtomicInteger state = new AtomicInteger(0);

    //当一个线程进行比较并修改值的时候,其他线程一直在while循环中
    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }
    public void unlock() {
        System.out.println("unlock...");
        state.set(0);
    }

    public static void main(String[] args) {
        LockCas lock = new LockCas();
        new Thread(() -> {
            System.out.println("begin...");
            //当运行到lock代码,并将值修改为1
            lock.lock();
            try {
                System.out.println("lock...");
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //值修改为0
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            System.out.println("begin...");
            //当值被修改为1后,这个线程一直在while循环,只有等unlock,也就是值被修改为0后,就可以跳出while循环
            lock.lock();
            try {
                System.out.println("lock...");
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
