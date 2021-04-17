package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    //子类在实例化对象时,调用子类的构造方法时,默认会先调用父类的构造方法
    //当父类的构造方法自定义后,
    // 就要在子类的构造方法使用super显式调用自定义的父类的构造方法
    public NormalUser(String name) {
        super(name);
        System.out.println("Hello  "+ name);
        System.out.println("欢迎来到图书管理系统!");
        this.iOperation=new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("=====================");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("======================");

        //此时显示完菜单,就要接受用户要进行操作的数字
        Scanner scanner=new Scanner(System.in);
        //并返回要进行的操作数
        return scanner.nextInt();
    }
}
