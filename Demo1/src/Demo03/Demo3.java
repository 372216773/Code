package Demo03;

import java.util.Scanner;

//3.古典问题：有一对兔子，从出生后第 3 个月起每个月都生一对兔子，小兔子长到第三个月后每
//个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
//1.程序分析： 兔子的规律为数列 1,1,2,3,5,8,13,21....
public class Demo3 {

    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入月份:");
        int month = scanner.nextInt();

        int[] sum = new int[month];

        scanner.close();

        for (int i = 0; i < month; i++) {
            if (i == 0 || i == 1) {
                sum[i] = 1;
                System.out.println("第" + (i + 1) + "月的兔子总对数为:" + sum[i]);
            } else {
                sum[i] = sum[i - 1] + sum[i - 2];
                System.out.println("第" + (i + 1) + "月的兔子总对数为:" + sum[i]);
            }
        }
    }
}
