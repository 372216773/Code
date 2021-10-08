package package2.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccount {

    public static void main(String[] args) {
        /*初始金额10000元
        AccountUnsafe account = new AccountUnsafe(10000);
        Account.demo(account);
        out: 140 cost: 109 ms,结果显然不正确
        给临界区代码加上synchronized,结果正确 0 cost: 97 ms
        */

        AccountCas account = new AccountCas(10000);
        Account.demo(account);
        /*
        out: 0 cost: 88 ms,执行时间低于synchronized
         */
    }

}

//线程不安全的做法
class AccountUnsafe implements Account {
    //总金额(共享资源)
    private Integer balance;

    //初始化
    public AccountUnsafe(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        synchronized (this) {
            return this.balance;
        }
    }

    //取款
    //多个线程对共享资源进行写操作,就是临界区
    @Override
    public void withdraw(Integer amount) {
        synchronized (this) {
            balance -= amount;
        }
    }
}

//无锁实现
class AccountCas implements Account {
    //使用JDK提供的基于无锁的实现,这个实现就是AtomicInteger(原子整数)
    private AtomicInteger balance;

    public AccountCas(int balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        //得到原子整数的值
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        /*
        1.
        while (true) {
            //获得余额的最新值(局部变量,存储在局部内存中)
            int prev = balance.get();
            //获得修改后的值
            int next = prev - amount;
            //真正修改,prev与对象中的余额进行比较,相等,进行修改,不相等,不进行修改,重新进入while()
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }*/
        balance.getAndAdd(-1 * amount);
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