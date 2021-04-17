package user;

import book.BookList;
import operation.IOperation;

/*
不管是管理员,还是普通用户,都有一些共同属性
姓名
年龄
性别
等常见属性
菜单
让管理员对象和普通用户去继承这些共有的属性
如果只在管理员对象和普通用户单独来写菜单,在需要调用的时候
只能通过管理员对象和普通用户来调用方法,不能够发生多态
写在抽象方法中,子类来实现,以后调用的时候调用父类就行,
不用管调用是谁的菜单,实现多态
 */
public abstract class User {
    protected String name;
    //存储当前对象的所有的操作
    IOperation[] iOperation;

    //如果子类要继承抽象类并且实例化,就必须经过父类的构造方法
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    //选择操作
    public void doOperation(int choice, BookList bookList) {
        //调用当前对象的哪个操作,调用哪个操作的work()方法,进行操作
        this.iOperation[choice].work(bookList);
    }
}
