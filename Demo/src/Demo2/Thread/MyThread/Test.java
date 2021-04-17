package Demo2.Thread.MyThread;

public class Test {

    public static void main(String[] args) {

        MyThread1 thread1=new MyThread1("Thread1");

        //thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        MyThread1 thread2=new MyThread1("Thread2");

        //thread2.setPriority(Thread.MAX_PRIORITY);



        //thread2.start();



        for (int i = 0; i < 10; i++) {

            if (i==5|i==4|i==3){
                try {
                    thread1.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                thread1.yield();
                thread1.isDaemon();

            }

            System.out.println("main"+i);

        }


            }

        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println("main"+i);
//        }



