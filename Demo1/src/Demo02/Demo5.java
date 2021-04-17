package Demo02;

//5.从键盘上输入5个数字，输出这些数字的和与平均值，输出平均值与第三个数字的关系“大于”，
//        “小于”，“等于”

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {

        double[] arrays = new double[5];
        int i = 0;
        double sum = 0;
        double adv = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入五个数:");

        double num1 = scanner.nextDouble();
        arrays[i++] = num1;
        double num2 = scanner.nextDouble();
        arrays[i++] = num2;
        double num3 = scanner.nextDouble();
        arrays[i++] = num3;
        double num4 = scanner.nextDouble();
        arrays[i++] = num4;
        double num5 = scanner.nextDouble();
        arrays[i++] = num5;

        scanner.close();

        for (int j = 0; j < 5; j++) {
            sum += arrays[j];
        }

        adv = sum/5;

        System.out.println("五个数的和为:"+sum);
        System.out.println("五个数的平均数为:"+adv);
        if(adv>arrays[2]){
            System.out.println("大于");
        }else if (adv==arrays[2]){
            System.out.println("等于");
        }else{
            System.out.println("小于");
        }
    }
}
