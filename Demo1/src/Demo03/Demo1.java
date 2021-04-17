package Demo03;

import java.util.Scanner;

//1.从键盘上输入两个数字，求出这两个数字之间所有数字(整数)的和
public class Demo1 {

    public static void main(String[] args){

        double t = 0;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请分别输入这两个数字:");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        scanner.close();

        if(num1>num2){
            t=num1;
            num1=num2;
            num2=t;
        }
        for (int i = (int)num1+1; i < (int)num2; i++) {

            sum += i;

        }

        System.out.println(num1+"和"+num2+"之间的数值和为:"+sum);
    }
}
