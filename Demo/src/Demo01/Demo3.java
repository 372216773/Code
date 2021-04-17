package Demo01;

import java.util.Scanner;

//3. 输入年份和月份，输出这个月应该有多少天
public class Demo3 {
    public static void main(String[] args) {
        int[] a={0,31,28,31,30,31,30,31,31,30,31,30,31};//平年
        Scanner scanner=new Scanner(System.in);
        System.out.println("请分别输入年份和月份:");
        int year=scanner.nextInt();
        int month=scanner.nextInt();
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            a[2] = 29;
        }
            System.out.println("这个月一共有:"+a[month]+"天");
    }
}
