package Demo03;

import java.util.Scanner;

//15.打印出如下图案,行数由程序运行时输入
//*
//**
//***
//****
//*****
public class Demo15 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入要输出的行数:");
        int num = scanner.nextInt();

        scanner.close();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
