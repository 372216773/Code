package Demo3.Runnable.Demo1;

import java.util.concurrent.Callable;

public class MyThread1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int result=0;
        for (int i = 0; i <= 100; i++) {
            result+=i;
        }
        return result;
    }
}
