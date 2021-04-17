package Demo01;

import java.util.Scanner;

//1. 用户输入任意一个整数，求各位数字之和
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please input this number:");
        int number=scanner.nextInt();
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number/=10;
        }
        System.out.println("各位数字之和:"+sum);
    }
}
