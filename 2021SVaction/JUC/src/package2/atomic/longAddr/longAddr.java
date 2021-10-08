package package2.atomic.longAddr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
LongAddr,LongAccumulator性能比AtomicInteger,AtomicLong要高
 */
public class longAddr {
    public static void main(String[] args) {

        //AtomicLong
        for (int i = 0; i < 5; i++) {
            demo(
                    () -> new AtomicLong(0),
                    (param1) -> param1.getAndIncrement()
            );
        }

        //LongAdder
        for (int i = 0; i < 5; i++) {
            demo(
                    () -> new LongAdder(),
                    (param1) -> param1.increment()
            );
        }
    }

    /**
     *
     * @param adderSupplier 提供累加器对象 ()->返回结果
     * @param action 执行累加操作 (参数) -> 无返回结果
     * @param <T> 泛型
     */
    private static <T> void demo(Supplier<T> adderSupplier, Consumer<T> action) {
        //在Supplier中有get抽象方法,返回值类型为T,返回一个对象
        T adder = adderSupplier.get();
        long start = System.nanoTime();
        List<Thread> ts = new ArrayList<>();
        // 4 个线程，每人累加 50 万
        for (int i = 0; i < 4; i++) {
            ts.add(new Thread(() -> {
                for (int j = 0; j < 500000; j++) {
                    //在Consumer中有accept抽象方法,有一个参数,无返回值
                    action.accept(adder);
                }
            }));
        }
        ts.forEach(t -> t.start());
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(adder + " cost:" + (end - start) / 1000_000);
    }
}

