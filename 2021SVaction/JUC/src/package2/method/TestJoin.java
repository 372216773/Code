package package2.method;

/*
join()
 */
public class TestJoin {

    public static int res = 0;

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    public static void test() throws InterruptedException {
        System.out.println("开始");

        Thread thread = new Thread(() -> {
            System.out.println("开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束");
            res = 10;
        }, "thread1");
        thread.start();
        //Thread.sleep(1000);sleep()的时间并不确定,不好把握
        // 如果不进行操作,res打印的就是0,想要获取res最终结果,
        // 那就使用join()令主线程进行等待thread1线程执行完后,再唤醒主线程
        thread.join();
        System.out.println("结果为:    " + res);
        System.out.println("结束");
    }
}
