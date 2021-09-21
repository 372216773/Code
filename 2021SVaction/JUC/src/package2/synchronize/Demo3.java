package package2.synchronize;

public class Demo3 {
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        synchronized (lock) {
            lock.wait();
        }
    }
}
