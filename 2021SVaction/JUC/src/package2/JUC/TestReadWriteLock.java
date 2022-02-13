package package2.JUC;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();

        //method1(dataContainer);
        method2(dataContainer);
    }

    /**
     * 读-读是不互斥的,可同时进行
     *
     * @param dataContainer 数据容器对象
     */
    public static void method1(DataContainer dataContainer) {
        new Thread(() -> {
            dataContainer.read();
        }, "t1").start();

        new Thread(() -> {
            dataContainer.read();
        }, "t2").start();
    }

    /**
     * 读写是互斥的
     * @param dataContainer 数据容器对象
     */
    public static void method2(DataContainer dataContainer) {
        new Thread(() -> {
            dataContainer.read();
        }, "t1").start();

        new Thread(() -> {
            dataContainer.write();
        }, "t2").start();
    }
}

class DataContainer {
    private Object data;

    //创建可重入的读写锁对象
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //从读写锁对象中获取读锁
    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    //从读写锁对象中获取写锁
    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public Object read() {
        readLock.lock();
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    获取到读锁");
        try {
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    读取数据");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.data;
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    释放锁");
        }
    }

    public void write() {
        writeLock.lock();
        System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    获取到写锁");
        try {
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    写数据......");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis() + "    释放写锁");
        }
    }
}
