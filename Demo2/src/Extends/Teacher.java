package Extends;

public class Teacher extends Person{

    Teacher(){
        System.out.println("Teacher无参构造器");
    }

    public static void static_method(){//重写父类方法
        System.out.println("Teacher static_method");
    }

    public static void static_method(int i){//重载方法
        System.out.println("Teacher 重载 method");
    }
    public static void method1(){//静态方法不能重名
        System.out.println("Teacher static method");

    }
}
