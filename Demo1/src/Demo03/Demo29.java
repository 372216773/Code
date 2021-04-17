package Demo03;

import java.util.Scanner;

//29.求 x 的 n 次幂，x 和 n 从键盘输入
public class Demo29 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        System.out.println("请输入x:");
        int x = scanner.nextInt();
        System.out.println("请输入n:");;
        int n = scanner.nextInt();

        scanner.close();

        System.out.println(x+"x的"+n+"次幂为"+Math.pow(x,n));

    }

}
