package Demo01;

import java.util.Scanner;


//8.输入华氏温度 f，计算并输出相应的摄氏温度 c。c = 5/9(f-32)
public class Demo8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入华氏温度f:");
        double f = scanner.nextDouble();

        scanner.close();

        double C = 5/(9*(f-32));

        System.out.println("当前相应的摄氏温度C为"+C);
    }
}
