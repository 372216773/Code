package package2.pattern;
/*
保护性暂停,即Guarded Suspension,用在一个线程等待另一个线程的执行结果
 */
public class Test1 {
    static final GuardedObject guardedObject = new GuardedObject();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (guardedObject) {
                System.out.println(Thread.currentThread().getName()+" start");
                Object o = guardedObject.get(10000);
                System.out.println(o);
            }
        }, "client").start();

        new Thread(()->{
            Object o = "hello";
            System.out.println(Thread.currentThread().getName()+" start");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (guardedObject) {
                guardedObject.setResponse(o);
            }
        },"service").start();
    }
}

//
class GuardedObject {
    private Object response;

    public Object get(long timeout) {
        synchronized (this) {
            //获得开始时间
            long begin = System.currentTimeMillis();
            //经历时间
            long passedTime = 0;

            while (response == null) {
                System.out.println("......");
                //还要等待的时间
                long waitTime = timeout - passedTime;
                if (waitTime <= 0) {
                    System.out.println("超时");
                    break;
                }

                try {
                    //当wait()被notify唤醒,等待的时间没有超时
                    //再次wait()的时间就要减去上次被中断的时间
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
        }
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
        synchronized (this) {
            //唤醒休眠的线程
            this.notifyAll();
        }
    }
}
