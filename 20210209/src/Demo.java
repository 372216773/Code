class Node{
    int val;
    Node next;
        }
public class Demo {

    public static void main(String[] args) {

        Node q = new Node();
        Node p = new Node();

        //让p这个引用指向q这个引用目前指向的对象
        p = q;

        //p这个引用指向的对象中,有一个next引用.
        //让next引用指向q这个引用目前指向的对象
        p.next = q;

        //q引用中有一个next域,让p引用指向q的next这个引用目前指向的对象
        p = q.next;

        //p,q引用所指向的对象中都有一个next域,
        // 让"p引用"所指向的对象中的next引用,指向q引用所指向的对象中的next引用所指向的对象
        p.next = q.next;

        //p这个引用不指向任何对象
        p = null;

        /*
        一个引用可以指向另一个引用:❌
        java人为的规定:
        "引用是一种只能指向对象的数据类型"
        引用只能用来指向对象
        引用不能只想引用
        对象不能指向对象
        引用和对象不是一回事
        指针和地址就不是java概念
        java中没指针
        */

        /*
        一个引用在"同时"可以指向多个对象:❌
        一个引用可以指向多个对象,但不能同时指向多个对象
        多个引用可以指向一个对象
         */

        /*
        p == q;  p和q是否指向同一个对象,但null也可以
        p != q;  p和q是否指向不同对象
         */
    }

}
/*
==========================================
        基本数据类型(8种)
数据类型
                    class类型的引用     class A{}  A a;//a为class类型的引用
        引用数据类型
                    interface类型的引用 interface B{} B b;//b为interface类型的引用

                    数组类型的引用       int[] c;
class类型的"引用"只能指向 该类以及它的子类 类型的"对象"
A p = new AA(); 要么AA就是A,要么AA是A的子类
class A {}
class AA extends A{}

A a = new A();
A a = new AA();
-------------------------------------------
B p = new BB(); 要求BB类必须实现了B接口
interface B{}
class BB implements B{}

B b = new B();//接口不能构造对象
B b = new BB();
=======================================
重写发生在子类中
重载发生在本类中
class A{
    方法1();
    方法2();
    方法3();
}
class AA extends A {
    覆写方法1();
    覆写方法2();
    方法4();
    方法5();
}
main{
    A a = new AA();
    a.方法1();√    AA,因为被重写了
    a.方法2();√    AA,因为被重写了
    a.方法3();√    A,方法的运行看的是对象的类型,类型为A
    a.方法4();×
    a.方法5();×
}
通过引用可以调用什么方法,看的是引用类型
方法运行看的是对象的类型
其次,根据对象类型重写情况判断真正运行的是谁的方法
A a = new AA();
想要去调用方法4和方法5-->方法4,5都在AA中,所以将a向下转型为AA类型的
向下转型
AA b = (AA)a;
b.方法4();
b.方法5();
 */