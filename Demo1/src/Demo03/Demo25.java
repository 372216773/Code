package Demo03;

import java.util.Scanner;

//25.逆序输出一个整数的各位数字
public class Demo25 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个整数:");
        long num = scanner.nextLong();

        scanner.close();

        int con=0;
        long num_1 = num;

        while(num%10!=0){
            num = num/10;
            con++;
        }
        System.out.println("几位数:"+con);
        for (int i = 0; i < con; i++) {
            System.out.print(num_1%10);
            num_1 = num_1/10;
        }

    }

}
