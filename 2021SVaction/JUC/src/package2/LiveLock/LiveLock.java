package package2.LiveLock;

public class LiveLock {
    static int count = 10;
    public static void main(String[] args) {
        new Thread(()->{
            //减到0结束
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count --;
                System.out.println("count:"+count);
            }
        },"t1").start();

        new Thread(()->{
            //加到20结束
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count ++;
                System.out.println("count:"+count);
            }
        },"t2").start();
    }
}
