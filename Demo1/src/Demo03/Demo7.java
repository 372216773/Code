package Demo03;

import java.util.Scanner;

//7.输入两个正整数 m 和 n，求其最大公约数和最小公倍数。
//最小公倍数=两整数的乘积÷最大公约数
public class Demo7 {

    public static void main(String[] args){

        int i=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入两个正整数:");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        scanner.close();

        int j = m>n?m=n:m;
        for (i =j; (i > 1)&&(m%i!=0||n%i!=0); i--) {}
        if(i>1){
            System.out.println(i+"是"+m+"和"+n+"的最大公约数");
            System.out.println((m*n/i)+"是"+m+"和"+n+"的最小公倍数");
        }

    }
}
