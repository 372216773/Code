package Demo02;

import java.util.Scanner;

//4.从键盘上输入 3 个数字，找出最大值是多少和最小值
public class Demo4 {

    public static void main(String[] args){

        double max,min;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入三个数:");

        double num1 = scanner.nextDouble();
        max = num1;
        double num2 = scanner.nextDouble();
        if(num2>max){
            max = num2;
        }
        double num3 = scanner.nextDouble();
        if(num3>max){
            max = num3;
        }

        scanner.close();

        min = num1;
        if(num2<min){
            min = num2;
        }
        if(num3<min){
            min = num3;
        }


        System.out.println("max="+max);
        System.out.println("min="+min);

    }
}
