package package1.thread;
/*
implements Runnable

        Dog dog = new Dog();
        Thread package1.thread = new Thread(dog);
        package1.thread.start();

 */
public class Thread2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Person person = new Person();

        Thread thread = new Thread(dog);
        Thread thread1 = new Thread(person);
        thread.start();
        thread1.start();
    }
}

class Dog implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (count < 50) {
            System.out.println("Wooooo~" + count++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Person implements Runnable {

    int count = 0;

    @Override
    public void run() {
        while (count < 60) {
            System.out.println("Hi~ o(*￣▽￣*)ブ~" + count++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}