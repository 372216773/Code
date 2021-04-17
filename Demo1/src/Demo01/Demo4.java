package Demo01;

import java.util.Scanner;

//4.从键盘上输入梯形的上底，下底和高，计算出梯形的面积
public class Demo4 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入梯形上底:");
        double upper_line = scanner.nextDouble();

        System.out.println("请输入梯形下底:");
        double lower_line = scanner.nextDouble();

        System.out.println("请输入梯形高:");
        double height = scanner.nextDouble();

        scanner.close();

        double trapezoidal_area = (upper_line+lower_line)*height/2;

        System.out.println("梯形面积为:"+trapezoidal_area);
    }
}
