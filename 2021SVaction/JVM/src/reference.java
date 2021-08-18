import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
-Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class reference {

    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        //StrongReference();

        //当内存紧张时,就回收内存
        //SoftReference();

        //
        WeakReference();
    }

    public static void StrongReference() {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4MB]);
        }
    }

    public static void SoftReference() {
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            //关联软引用队列,当引用所指的对象被回收时,软引用就加入到引用队列中
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(reference.get());
            list.add(reference);
            System.out.println(list.size());
        }
        //从队列中获取无用的软引用对象
        Reference<? extends byte[]> poll = queue.poll();
        //移除list中的无用的软引用
        while(poll!=null) {
            list.remove(poll);
            poll = queue.poll();
        }
        System.out.println("=======================");
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }

    public static void WeakReference() {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> reference = new WeakReference<>(new byte[_4MB]);
            list.add(reference);

            for (WeakReference<byte[]> ref : list) {
                System.out.print(ref.get()+" ");
            }
            System.out.println();
        }
    }

}
