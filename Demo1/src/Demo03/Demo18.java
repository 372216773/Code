package Demo03;

import java.util.Scanner;

//18.求 n 的阶乘，n 从控制台输入
public class Demo18 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个数:");
        int num = scanner.nextInt();

        scanner.close();
        long sum = 1;
        for (int i = 1; i <= num; i++) {
            sum = sum*i;
        }
        System.out.println(num+"的阶乘为:"+sum);

    }

}
