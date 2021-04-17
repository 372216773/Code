package com.wj;

class Money implements Cloneable{
    public int money=12;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//想要克隆就继承cloned接口
//并且要实现clone方法
class Person implements Cloneable{
    public String name;
    public Money money;
    Person(String name) {
        this.name=name;
        this.money=new Money();
    }

    @Override//返回类型为Object
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();//拷贝后得到的引用
        //将克隆后的引用付给person
        Person person =(Person) super.clone();
        //将克隆好的引用付给money
        person.money =(Money) person.money.clone();
        //此时person这个引用中的name与money都完成了深拷贝,即与原对象无关,只是数据相同
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Demo2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person =new Person("Mary");
        Person person1 =(Person)person.clone();

        System.out.println(person.money.money);
        System.out.println(person1.money.money);

        //Money为浅拷贝,即只拷贝了引用,而没有拷贝对象,指向同一对象
        person1.money.money=45;

        System.out.println(person.money.money);
        System.out.println(person1.money.money);
    }

}
