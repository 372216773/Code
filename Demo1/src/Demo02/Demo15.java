package Demo02;

import java.util.Scanner;

//15.以下 4 种水果的单价分别是 3.00 元/公斤，2.50 元/公斤，4.10 元/公斤，10.20 元/公斤。
//[1] apples
//[2] pears
//[3] oranges
//[4] grapes
//输入水果的编号，输出该水果的单价。如果输入不正确的编号，显示输入有误。
public class Demo15 {

    public static void main(String[] args){
        double size_apples = 3.00;
        double size_pears = 2.50;
        double size_oranges = 4.10;
        double size_grapes = 10.20;
        String goods;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入编号:");
        int num = scanner.nextInt();

        scanner.close();

        switch (num){
            case 1:
                goods = "apples";
                System.out.println("["+num+"]"+goods+" 单价为:"+size_apples+"元/公斤");
                break;
            case 2:
                goods = "pears";
                System.out.println("["+num+"]"+goods+" 单价为:"+size_pears+"元/公斤");
                break;
            case 3:
                goods = "oranges";
                System.out.println("["+num+"]"+goods+" 单价为:"+size_oranges+"元/公斤");
                break;
            case 4:
                goods = "grapes";
                System.out.println("["+num+"]"+goods+" 单价为:"+size_grapes+"元/公斤");
                break;
        }
    }
}
