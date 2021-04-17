package Demo02;

//2.从键盘桑输入分数，输出该分数的等级，
//        E ： 不及格
//        D ： 60-70
//        C ： 71-80
//        B ： 81-90
//        A ： 91-100

import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入分数:");
        int score = scanner.nextInt();

        switch(score/10) {
            case 10:
            case 9:
                System.out.println("A级！");
                break;
            case 8:
                System.out.println("B级！");
                break;
            case 7:
                System.out.println("C级！");
                break;
            case 6:
                System.out.println("D级！");
                break;
            default:
                System.out.println("E级！");
                break;
        }
        scanner.close();
    }
}
