package Demo7;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);


        System.out.println("请输入格式例如(4 + 5)的式子来进行计算:");
        double num1=scanner.nextDouble();
        char cal=scanner.next().charAt(0);
        double num2=scanner.nextDouble();

        scanner.close();

        Calculation calculation=new Calculation();

        if(cal=='+'){
            calculation.add(num1,num2);
        }else if (cal=='-'){
            calculation.sub(num1,num2);
        }else if (cal=='*'){
            calculation.times(num1,num2);
        }else if (cal=='/'){
            calculation.div(num1,num2);
        }else{
            System.out.println("输入有误");
        }

    }

}
