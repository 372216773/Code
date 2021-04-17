package Demo01;

import java.util.Scanner;

//6.从键盘上输入人民币的金额，计算出最少要几张人民币！
public class Demo6 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入人民币金额:");
        double num = scanner.nextDouble();


        int n1 = (int)num/100;
        int n2 = (int)(num%100)/50;
        int n3 = (int)((num%100)%50)/20;
        int n4 = (int)(((num%100)%50)%20)/10;
        int n5 = (int)((((num%100)%50)%20)%10)/5;
        int n6 = (int)(((((num%100)%50)%20)%10)%5)/1;
        int n7 = (int)(((((((num%100)%50)%20)%10)%5)%1)*10)/5;
        int n8 = (int)((((((((num%100)%50)%20)%10)%5)%1)*10)%5)/1;

        int total = n1+n2+n3+n4+n5+n6+n7+n8;

        System.out.println("最少需要:"+total+"张人民币");

    }
}
