package Demo01;

//7.从键盘上输入两个数字，求出这 2 个数字的和差积商，若第二个数字为 0，则商出入除数不能为
//        0

import java.util.Scanner;

public class Demo7 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个数:");
        double num1 = scanner.nextDouble();

        System.out.println("请输入第二个数:");
        double num2 = scanner.nextDouble();

        scanner.close();

        System.out.println("和为:"+(num1+num2));
        System.out.println("差为:"+(num1-num2));
        System.out.println("积为:"+(num1*num2));
        if(num2==0){
            System.out.println("被除数不能为零");
        }else{
            System.out.println("商为:"+(num1/num2));
        }

    }
}
