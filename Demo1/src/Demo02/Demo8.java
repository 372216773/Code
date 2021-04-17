package Demo02;

import java.util.Scanner;

//8.从键盘上输入年月日，输出该天是这一年中的第几天
public class Demo8 {
    public static void main(String[] args) {

        int sum=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入年:");
        int year = scanner.nextInt();
        System.out.println("请输入月:");
        int month = scanner.nextInt();
        System.out.println("请输入日:");
        int day = scanner.nextInt();


        scanner.close();
        int data[] = {31,29,31,30,31,30,31,31,30,31,30,31};
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            data[1] = data[1] - 1;
        };
        for(month=month-1;month>-1;month--)
        {
            sum+=data[month];
        }
        System.out.println("该天是第"+sum+"天");
    }
}
