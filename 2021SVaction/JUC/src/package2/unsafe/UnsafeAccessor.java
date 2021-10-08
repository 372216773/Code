package package2.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*
使用自定义的 AtomicData 实现之前线程安全的原子整数 Account 实现
 */
public class UnsafeAccessor {
    public static void main(String[] args) {
        MyAtomicInteger myAtomicInteger = new MyAtomicInteger(10000);
        Account.demo(myAtomicInteger);
    }
}
/*
实现AtomicInteger
 */
class MyAtomicInteger implements Account {

    //保护的整数
    private final int value;
    //偏移量
    private static final long valueOffset;
    //unsafe对象
    private static Unsafe UNSAFE = null;

    static {
        Field theUnsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert theUnsafe != null;
        theUnsafe.setAccessible(true);
        //获得成员变量的值,静态属性不需要传递对象
        try {
            UNSAFE = (Unsafe) theUnsafe.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void decrement(int amount) {
        while (true) {
            int prev = this.value;
            int next = prev - amount;
            if (UNSAFE.compareAndSwapInt(this, valueOffset, prev, next)) {
                break;
            }
        }
    }

    @Override
    public Integer getBalance() {
        return this.value;
    }

    @Override
    public void withdraw(Integer amount) {
        decrement(amount);
    }
}

interface Account {

    //获取金额
    Integer getBalance();

    //取款
    void withdraw(Integer amount);

    /*
    方法内会启动1000个线程,每个线程做-10元的操作
    如果初始余额为10000,那么正确的结果应当是0
     */
    static void demo(Account account) {
        List<Thread> ts = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        long start = System.nanoTime();
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end - start) / 1000_000 + " ms");
    }
}