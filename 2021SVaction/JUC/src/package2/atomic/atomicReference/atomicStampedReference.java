package package2.atomic.atomicReference;

import java.util.concurrent.atomic.AtomicStampedReference;

/*
atomicStampedReference用版本号解决ABA问题
 */
public class atomicStampedReference {
    //初始值以及版本号
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        //获取值
        String prev = ref.getReference();
        //获取版本号
        int stamp = ref.getStamp();
        System.out.println(Thread.currentThread().getName() + ": " + ref.getStamp());
        other();
        Thread.sleep(1000);
        System.out.println("最开始版本号: " + stamp + "; " + Thread.currentThread().getName() + ": " + ref.getStamp());
        //比较两个东西,值和版本号都与主存中的数据相同,才能修改为新的值
        System.out.println("change A->C " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
        System.out.println(Thread.currentThread().getName() + ": " + ref.getStamp());
    }

    private static void other() throws InterruptedException {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + ref.getStamp());
            System.out.println("change A->B " + ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
        }).start();
        Thread.sleep(500);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + ref.getStamp());
            System.out.println("change B->A " + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
        }).start();
    }
}
