package Demo03;

import java.util.Scanner;

//19.给一个不多于 5 位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
public class Demo19 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个数字:");
        int num = scanner.nextInt();

        scanner.close();

        int con = 0;
        int num_1 = num;

        for (int i = 0; num!=0 ; i++) {
            num = num/10;
            con++;
        }

        int n=0;

        System.out.println(num_1+"是"+con+"位数");

        System.out.print("逆置后的数:");
        for (int i = 0; i < con; i++) {
             n = num_1%10;
             num_1 = num_1/10;
            System.out.print(n);
        }

    }

}
