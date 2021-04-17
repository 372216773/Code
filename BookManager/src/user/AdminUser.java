package user;

import operation.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        System.out.println("Hello  "+ name);
        System.out.println("欢迎来到图书管理系统!");
        //储存当前对象的所有操作
        this.iOperation = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=====================");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示所有图书");
        System.out.println("0.退出系统");
        System.out.println("======================");

        //此时显示完菜单,就要接受用户要进行操作的数字
        Scanner scanner=new Scanner(System.in);
        //并返回要进行的操作数
        return scanner.nextInt();
    }
}
