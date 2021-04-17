import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/*
用来执行的类
 */
public class Main {

    //登陆的方法
    //返回值为为User,如果没有使用就会返回两种类型,会很麻烦
    //这就体现了多态的好处,向上转型,子类可以直接用父类类型返回
    //此时返回一个对象,在main方法中直接使用父类类型接收这个对象
    public static User login() {
        System.out.println("你的名字:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("你的身份:");
        System.out.println("1.管理员           2.普通用户");
        int id = scanner.nextInt();
        //显示菜单
        if (id == 1) {
            //如果是管理员,就新建一个管理员用户
            return new AdminUser(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        //登陆时新建一个BookList对象,初始时会有三本书
        BookList bookList = new BookList();
        //父类类型接收这个对象,向上转型,体现多态
        User user = login();
        //不断地接受要进行操作的指令
        while(true) {
            //动态绑定,调用这个对象的menu方法,但是不知道这个对象是谁
            //menu会返回一个值,对应的是将要进行的操作,定义一个值choice来接收
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }
}
