/*
堆内存演示
 */
public class heapMemory {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("第一阶段......");
        Thread.sleep(20000);

        //10MB
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println("第二阶段......");
        Thread.sleep(20000);

        bytes=null;
        System.gc();
        System.out.println("第三阶段......");
        Thread.sleep(100000);
    }
}
