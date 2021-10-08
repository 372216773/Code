package package2.atomic.atomicReference;

import java.util.concurrent.atomic.AtomicReference;
/*
主线程仅能判断出共享变量的值与初值 A 是否相同，不能感知到这种从 A 改为 B 又 改回 A 的情况，如果主线程希望:
只要有其它线程【动过了】共享变量，那么自己的 cas 就算失败，这时，仅比较值是不够的，需要再加一个版本号
 */
public class matterABA {

    static AtomicReference<String> ref = new AtomicReference<>("A");

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start......");
        //得到初始值
        String prev = ref.get();
        //
        other();
        Thread.sleep(1000);
        //尝试改为"C"
        System.out.println(ref.get()+" "+ref.compareAndSet(prev,"C"));
    }

    private static void other() throws InterruptedException {
        new Thread(()-> {
            System.out.println("change A->B " + ref.compareAndSet("A", "B"));
        }).start();
        Thread.sleep(500);
        new Thread(()-> {
            System.out.println("change B->A " + ref.compareAndSet("B", "A"));
        }).start();
    }
}
