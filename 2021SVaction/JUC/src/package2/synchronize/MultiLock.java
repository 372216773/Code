package package2.synchronize;
/*
多把锁
 */
public class MultiLock {
    public static void main(String[] args) {
        BigRoom1 bigRoom = new BigRoom1();

        new Thread(()->{
            try {
                bigRoom.study();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小明").start();

        new Thread(()->{
            try {
                bigRoom.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小红").start();
    }
}

/*
    加上synchronized后,此时房间只能一个人用,另一个只能等待,串行执行的,并发度低
 */
class BigRoom {

    public void sleep() throws InterruptedException {
        synchronized (this) {
            System.out.println("sleeping......2s");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (this) {
            System.out.println("studying......1s");
            Thread.sleep(1000);
        }
    }
}

/*
降低锁的粒度,睡觉只需锁住卧室,学习只需锁住书房即可,相互之间不影响,不必锁住整个房子,增加并行量
 */
class BigRoom1 {

    //将锁的粒度降低
    private final Object studyRoom = new Object();
    private final Object bedRoom = new Object();

    public void sleep() throws InterruptedException {
        synchronized (bedRoom) {
            System.out.println("sleeping......2s");
            Thread.sleep(2000);
        }
    }

    public void study() throws InterruptedException {
        synchronized (studyRoom) {
            System.out.println("studying......1s");
            Thread.sleep(1000);
        }
    }
}
