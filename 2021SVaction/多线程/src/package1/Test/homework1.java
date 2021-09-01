package package1.Test;

import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        //用extends Thread
        T1 t1 = new T1();
        t1.start();

        //用implements Runnable
        T2 t2 = new T2(t1);
        Thread thread = new Thread(t2);//代理模式
        thread.start();
    }
}

class T1 extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("T1线程退出");
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class T2 implements Runnable {

    private T1 t1;
    Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入(Q)表示退出");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                this.t1.setLoop(false);
                System.out.println("T2线程退出");
                break;
            }
        }
    }
}
