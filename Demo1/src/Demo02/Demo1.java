package Demo02;

import java.util.Scanner;

//1.从键盘上输入分数，请判断出该分数是否及格
public class Demo1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入分数:");
        double score = scanner.nextDouble();

        scanner.close();

        if(score>60){
            System.out.println("合格");
        }else{
            System.out.println("不合格");
        }
    }
}
