package Extends;

public class Person {

    public String name;
    public String sex;
    public int age;
    public long Id;
    private double money;//私有属性,不能继承

    Person(){
        System.out.println("Person父类无参构造器");
    }

    Person(String name,String sex,int age,long Id){
        System.out.println("Person父类有参构造器");
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.Id=Id;
    }

    public void method(){
        System.out.println("Person method");
    }

    public static void static_method(){//静态方法中的属性和方法都必须是静态的,这是初始化实际不同影响的
        System.out.println("static Person method");
    }

}
