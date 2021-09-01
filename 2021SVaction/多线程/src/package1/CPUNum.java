package package1;

public class CPUNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑CPU数量
        int processors = runtime.availableProcessors();
        System.out.println("当前电脑CPU个数:  " + processors);
    }
}
