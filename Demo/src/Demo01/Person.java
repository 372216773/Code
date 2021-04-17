package Demo01;

public class Person {
    public int age;
    public String name;
    public String id;
    public final int ele = 213;

    private Person(){
        System.out.println("Person的无参构造方法");
    }

    public static Person method1(){
        return new Person();//会产生多个对象,那如何多次调用,只会产生一个对象呢
    }

    private static Person person=new Person();

    public static Person method2(){

        return person;//饿汉机制

    }

    private static Person person1=null;
    public static Person method3(){//饱汉机制

        if(person1==null){
            person1=new Person();
        }
        return person1;
    }

    public static Person person2=new Person();

    public void method() {
        String methodNum;
        System.out.println("age:" + age + "name:" + name + "id:" + id);
        //System.out.println("methodNum"+methodNum);
        class methodInner{
            public void methodInnerMethod(){
                System.out.println("methodInnerMethod");
            }
        }
        methodInner m= new methodInner();
        m.methodInnerMethod();

    }

    public class Inner {
        public String innerName;

        public void innerMethod() {
            //内部类可以访问外部类的成员
            System.out.println(innerName);
        }
    }
    public static class Inner1 {
        public String innerName1;

        public void innerMethod1() {
            //内部类可以访问外部类的成员
            System.out.println(innerName1);
        }
    }
}
