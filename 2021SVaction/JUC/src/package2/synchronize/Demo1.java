package package2.synchronize;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                room.increment();
            }
        }, "t1");

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500000; i++) {
                room.decrement();
            }
    },"t2");

        thread.start();
        thread1.start();
    //主线程等待调用的线程结束,再去执行其他线程
        thread.join();
        thread1.join();
        System.out.println(room.getCount());
}
}


class Room {
    private int count = 0;

    public void increment(){
        synchronized (this) {
            count++;
        }
    }

    public void decrement(){
        synchronized (this) {
            count--;
        }
    }

    public int getCount(){
        //避免读到中间值,确保读到的是操作执行完后的数据
        synchronized (this) {
            return count;
        }
    }
}
