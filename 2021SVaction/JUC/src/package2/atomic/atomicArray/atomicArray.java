package package2.atomic.atomicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class atomicArray {
    public static void main(String[] args) {
        demo(
                () -> new int[10],
                (array) -> array.length,
                //会出现线程问题,多个线程同时拿到相同的array[index]值,进行加一
                (array, index) -> array[index]++,
                (array) -> System.out.println(Arrays.toString(array))
        );

        demo(
                () -> new AtomicIntegerArray(10),
                (array) -> array.length(),
                (array,index)-> array.getAndIncrement(index),
                (array)-> System.out.println(array)
                );
    }

    /**
     * @param arraySupplier 提供数组,可以是线程不安全的或线程安全的
     * @param lengthFun     获取数组长度的方法
     * @param putConsumer   自增方法,回传array,index
     * @param printConsumer 打印数组的方法
     * @param <T>           泛型
     */
    public static <T> void demo(
            Supplier<T> arraySupplier,
            Function<T, Integer> lengthFun,
            BiConsumer<T, Integer> putConsumer,
            Consumer<T> printConsumer) {
        List<Thread> threadList = new ArrayList<>();
        //获得数组,并赋值
        T array = arraySupplier.get();
        //获得数组的长度,确定线程的个数
        int length = lengthFun.apply(array);
        for (int i = 0; i < length; i++) {
            //每个线程对数组做10000次操作
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    putConsumer.accept(array, j % length);
                }
            }));
        }

        threadList.forEach(t -> t.start()); // 启动所有线程
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });     // 等所有线程结束
        printConsumer.accept(array);
    }
}
