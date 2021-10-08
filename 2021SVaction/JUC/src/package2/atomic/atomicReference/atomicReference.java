package package2.atomic.atomicReference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/*
原子引用
 */
public class atomicReference {
    public static void main(String[] args) {
        DecimalAccountCas decimalAccountCas = new DecimalAccountCas(new BigDecimal("10000"));
        DecimalAccount.demo(decimalAccountCas);
    }
}

class DecimalAccountCas implements DecimalAccount {

    //Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。
    //不安全
    //private BigDecimal balance;
    //
    private AtomicReference<BigDecimal> balance;

    public DecimalAccountCas(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return this.balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true) {
            BigDecimal prev = this.balance.get();
            BigDecimal next = prev.subtract(amount);
            if (balance.compareAndSet(prev, next)) break;
        }
    }
}

//对小数的操作
interface DecimalAccount {

    //获取金额
    BigDecimal getBalance();

    //取款
    void withdraw(BigDecimal amount);

    /*
    方法内会启动1000个线程,每个线程做-10元的操作
    如果初始余额为10000,那么正确的结果应当是0
     */
    static void demo(DecimalAccount account) {
        List<Thread> ts = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(BigDecimal.TEN);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(account.getBalance());
    }
}
