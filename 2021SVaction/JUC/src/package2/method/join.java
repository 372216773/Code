package package2.method;

/*
join()
 */
public class join {

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
            res=10;
        },"thread1");
        thread.start();
        Thread.sleep(1001);
        System.out.println("结果为:    "+res);
        System.out.println("结束");
    }
}
