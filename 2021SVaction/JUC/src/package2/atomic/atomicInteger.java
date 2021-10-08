package package2.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/*
原子int整数操作
 */
public class atomicInteger {
    public static void main(String[] args) {
        //无参初始值为0
        AtomicInteger atomicInteger = new AtomicInteger(5);

        /*
        //自增并且获取值(原子的 cas保证) <==> ++i
        System.out.println(atomicInteger.incrementAndGet());

        //获取值并且自增(原子的 cas保证) <==> i++
        System.out.println(atomicInteger.getAndIncrement());

        //获取i
        System.out.println(atomicInteger.get());

        //增加3再获取
        System.out.println(atomicInteger.addAndGet(3));

        //获取再增加3
        System.out.println(atomicInteger.getAndAdd(3));

        System.out.println(atomicInteger.get());*/

        //先做运算再读取值                                 读取到得值   设置的值
        //System.out.println(atomicInteger.updateAndGet(value -> value * 10));

        System.out.println(updateAndGet(atomicInteger, value -> value * 10));

    }

    //实现updateAndGet的原子操作,但无通用性,只能做单一的运算
    public static void updateAndGetBefore(AtomicInteger atomicInteger) {
        while (true) {
            //获取当前值
            int prev = atomicInteger.get();
            //修改后的值
            int next = prev * 10;
            //如果当前值与主存中的值不相同,不修改值,返回false
            //相同,修改值,返回true
            if (atomicInteger.compareAndSet(prev, next)) break;
        }
        return;
    }

    //实现updateAndGet的原子操作,增加其通用性                               一元(只接受一个参数)
    public static int updateAndGet(AtomicInteger atomicInteger, IntUnaryOperator operator) {
        while (true) {
            //获取当前值
            int prev = atomicInteger.get();
            //修改后的值,具体的实现由自己实现
            int next = operator.applyAsInt(prev);
            //如果当前值与主存中的值不相同,不修改值,返回false
            //相同,修改值,返回true
            if (atomicInteger.compareAndSet(prev, next)) return next;
        }
    }
}
