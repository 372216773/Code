package Demo02;

import java.util.Scanner;

//9.从键盘上输入出生年份，判断是否符合公司招聘要求（要求 18-40 岁）
public class Demo9 {

    public static void main(String[] args){

        int month_sum=0;
        int sum=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入出生年份:");
        int year = scanner.nextInt();
        System.out.println("请输入出生月份:");
        int month = scanner.nextInt();
        System.out.println("请输入出生日:");
        int day = scanner.nextInt();
        System.out.println("请输入今年年份:");
        int now_year = scanner.nextInt();
        System.out.println("请输入今年月份:");
        int now_month = scanner.nextInt();
        System.out.println("请输入这月第几天:");
        int now_day = scanner.nextInt();


        scanner.close();

        int data[] = {31,29,31,30,31,30,31,31,30,31,30,31};


        for (int i = 0; i < now_year-year; i++) {
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                data[1] = data[1] - 1;
            };
            for (int j = 0; j < data.length; j++) {
                sum += data[j];
            }

        }

        for(;month< data.length;month++)
        {
            month_sum+=data[month];
        }
        for(month=now_month;month > -1;month--)
        {
            month_sum+=data[month];
        }

        sum = sum + month_sum;

        if(18*366<sum&&sum<40*365){
            System.out.println("符合要求");
        }else{
            System.out.println("不符合要求");
        }

    }
}
