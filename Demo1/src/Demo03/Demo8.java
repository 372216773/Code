package Demo03;

import java.util.Scanner;

//8.求 s=a+aa+aaa+aaaa+aa...a 的值，其中 a 是一个数字。例如 2+22+222+2222+22222(此
//时共有 5 个数相加)，几个数相加有键盘控制。
public class Demo8 {

    public static void main(String[] args){

        int sum=0;
        int num;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入a:");
        int a = scanner.nextInt();
        System.out.println("请输入相加数数量:");
        int con = scanner.nextInt();

        scanner.close();


        for (int i = 0; i < con; i++) {
            num = a;
            for (int j = 0; j < i; j++) {
                num = num*10+a;
            }
            sum += num;
        }
        System.out.println("s="+sum);


    }

}
