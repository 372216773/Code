package package1.syn;

//模拟线程的死锁现象
public class DeadLock {
    public static void main(String[] args) {
        DeadLockDemo deadLock = new DeadLockDemo(true);
        deadLock.setName("A线程");
        DeadLockDemo deadLock1 = new DeadLockDemo(false);
        deadLock1.setName("B线程");
        deadLock.start();
        deadLock1.start();
    }
}

class DeadLockDemo extends Thread {
    //保证多线程共享一个对象,使用static
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    /*
    当A线程flag为true,会先拿到o1的锁,
    如果o2的锁还没有线程占有,那就可以拿到o2的锁执行完if中的代码,否则会一直在等待o2锁的释放,拿到锁才能进入下一步
    当B线程的flag为false,会先拿到o2的锁,
    如果o1的锁还没有线程占有,那就可以拿到o1的锁执行完else中的代码,否则会一直在等待o1锁的释放,拿到锁才能进入下一步
    =============================================
    此时A,B线程同时开始执行,
    A拿到o1的锁,B拿到o2的锁,
    然后A要进行下一步就要拿到o2的锁,但是o2的锁在B手中
    B要进行下一步就要拿到o1的锁,但是o1的锁在A手中
    两个线程就会一直在等待锁的释放,就形成了死锁
     */
    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {//通过synchronized加对象互斥锁,下边的就是同步代码
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}
