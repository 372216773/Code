/*
Java.lang.stackOverflowError 栈内存溢出
 */
public class stackOverflowError {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("递归调用次数: " + count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }

}
