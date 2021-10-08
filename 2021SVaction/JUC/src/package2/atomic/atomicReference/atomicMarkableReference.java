package package2.atomic.atomicReference;

import java.util.concurrent.atomic.AtomicMarkableReference;

/*
atomicMarkableReference是atomicStampedReference的简化版
 */
public class atomicMarkableReference {
    static AtomicMarkableReference<String> ref = new AtomicMarkableReference<>("A", true);

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + ": start");
        other();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+": " + ref.getReference());
        System.out.println(Thread.currentThread().getName() + ": change A->C mark " + ref.compareAndSet(ref.getReference(), "C", true, false));
        System.out.println(Thread.currentThread().getName()+": " + ref.getReference());
    }

    static void other() {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+": " + ref.getReference());
            System.out.println(Thread.currentThread().getName() + ": change A->B mark " + ref.compareAndSet(ref.getReference(), "B", true, false));
        }, "t1").start();
    }
}
