package package2.Volatile;

/*
可见性问题
 */
public class Demo {
    //不加volatile时,因为t1线程频繁的访问主内存中的run变量,
    // 所以JIT即时编译器就会就会将run的值缓存到自己的工作内存中的高速缓存中
    //如果此时修改run的值,t1线程的执行不会受到影响,就出现了可见性的问题
    // public static boolean run = true;

    //加了volatile,会避免线程从自己的工作缓存中读取变量的值,必须到主存中读取变量的值
    volatile public static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (true) {
                //执行代码
                if (!run) {
                    break;
                }
            }
        }, "t1").start();


        Thread.sleep(1000);
        run = false;
    }
}
