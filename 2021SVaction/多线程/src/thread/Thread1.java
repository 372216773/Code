package thread;
/*
extends Thread

        Cat cat = new Cat();
        cat.start();
 */
public class Thread1 {

    public static void main(String[] args) throws InterruptedException {
        //创建一个对象,可以当作一个线程使用
        Cat cat = new Cat();
        //启动线程,最终会执行run方法,那为什么不直接调用run方法
        /*
        run方法就是一个普通的方法,没有真正的启动一个线程,那就是顺序执行完,才向下执行,就没有使用到线程
         */
        cat.start();
        System.out.println("主线程名:   " + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            System.out.println("i: " + i);
            Thread.sleep(1000);
        }
    }
}

/*
当一个类继承Thread类,该类可以当作线程使用
重写run方法,实现自己的业务逻辑
Thread类中的run方法是实现了Runnable接口的run方法
 */
class Cat extends Thread {

    int time = 0;

    @Override
    public void run() {

        while (time < 80) {
            //每隔一秒,输出一段话
            System.out.println("妙啊~" + time++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
