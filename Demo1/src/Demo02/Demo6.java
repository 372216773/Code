package Demo02;

import java.util.Scanner;

//6.从键盘上输入一个数字，判断这个数字是否是 7 的倍数（x%7==0）
public class Demo6 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个数:");
        double num = scanner.nextDouble();

        scanner.close();

        if(num%7==0){
            System.out.println(num+"是7的倍数");
        }else{
            System.out.println(num+"不是7的倍数");
        }
    }
}
