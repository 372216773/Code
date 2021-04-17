package Demo03;

import java.util.Scanner;

//2.使用程序计算出存入余额宝的收益，本金（自己输入），利率（每天万份收益）
//，时间（天数，自己输入）
//总金 = 本金 + 本金/10000 * (当日万份收益)利率
public class Demo2 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入本金:");
        double money = scanner.nextDouble();
        System.out.println("请输入存储时间");
        int time = scanner.nextInt();

        scanner.close();

        double money_rate = 0.012;

        System.out.println("收益为:"+(money/10000*money_rate*time));

    }
}
