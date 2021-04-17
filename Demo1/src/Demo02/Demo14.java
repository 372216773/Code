package Demo02;

import java.util.Scanner;

//14.输入一个职工的月薪 salary，输出应交的个人所得税 tax。
//tax = rate * (salary-850)
//当 salary <= 850 时，rate = 0%;
//当 850 < salary <= 1350 时，rate = 5%;
//当 1350 < salary <= 2850 时，rate = 10%;
//当 2850 < salary <= 5850 时，rate = 15%;
//当 5850 < salary 时，rate = 20%;
public class Demo14 {

    public static void main(String[] args){

        double rate=0;
        double tax=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个职工的月薪 salary:");
        int salary = scanner.nextInt();

        scanner.close();

        if(salary <= 850){
            rate = 0;
            System.out.println("tax="+rate * (salary-850));
        }else if (850<salary&&salary<=1350){
            rate = 0.05;
            System.out.println("tax="+rate * (salary-850));
        }else if (1350<salary&&salary<=2850){
            rate = 0.1;
            System.out.println("tax="+rate * (salary-850));
        }else if (2850<salary&&salary<=5850){
            rate = 0.15;
            System.out.println("tax="+rate * (salary-850));
        }else if (5850 < salary){
            rate = 0.2;
            System.out.println("tax="+rate * (salary-850));
        }
    }
}
