package package2.JUC;

import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {
    public static void main(String[] args) throws InterruptedException {
        //
        DataContainerStamped dataContainer = new DataContainerStamped(2);

        //Thread.sleep(1000);
        new Thread(() -> {
            System.out.println(dataContainer.read(1));
        }, "t1").start();
        //Thread.sleep(1000);

        new Thread(() -> {
            //dataContainer.read(1);
            dataContainer.write(3);
        }, "t2").start();
    }
}

class DataContainerStamped {
    private int data;
    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data) {
        this.data = data;
    }

    //相较于读写锁的优化
    public int read(int readTime) {
        long stamp = lock.tryOptimisticRead();
        System.out.println(Thread.currentThread().getName() + " optimistic read locking stamp = " + stamp);
        try {
            Thread.sleep(readTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //stamp的值未被改变,返回true
        if (lock.validate(stamp)) {
            System.out.println(Thread.currentThread().getName() + " read finish stamp = " + stamp);
            return this.data;
        }

        //stamp的值被改变,锁升级,升级为读锁
        System.out.println(Thread.currentThread().getName() + " updating to read lock... stamp = " + stamp);
        try {
            //写锁在执行时,读锁会被阻塞住,写锁释放后,才会加上写锁
            stamp = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " read lock stamp = " + stamp);
            try {
                Thread.sleep(readTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " read finish stamp = " + stamp);
            return this.data;
        } finally {
            System.out.println(Thread.currentThread().getName() + " read unlock stamp = " + stamp);
            lock.unlockRead(stamp);
        }
    }

    public void write(int newData) {
        long stamp = lock.writeLock();
        System.out.println(Thread.currentThread().getName() + " write lock stamp = " + stamp);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            this.data = newData;
        } finally {
            System.out.println(Thread.currentThread().getName() + " write unlock stamp = " + stamp);
            lock.unlockWrite(stamp);
        }
    }
}
