package Demo01;

import java.util.Scanner;

//2. 选择一个形状（1长方形、2正方形、3三角形、4圆形）
//        根据不同的选择让用户输入不同的信息，长方形有长和宽、正方形有边长、三角形有底和高、圆形有半径
//        计算输出指定形状的面积
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("===================================");
            System.out.println("[1]:长方形");
            System.out.println("[2]:三角形");
            System.out.println("[3]:正方形");
            System.out.println("[4]:圆形");
            System.out.println("[5]:exit");
            System.out.println("please input this information:");
            int square = scanner.nextInt();
            if (square == 1) {
                System.out.println("请分别输入长和宽:");
                int height = scanner.nextInt();
                int width = scanner.nextInt();
                System.out.println("长方形面积:" + (height * width));
            } else if (square == 2) {
                System.out.println("请分别输入底和高:");
                double height = scanner.nextInt();
                double width = scanner.nextInt();
                System.out.println("三方形面积:" + (height * width / 2));
            } else if (square == 3) {
                System.out.println("请输入边长:");
                int width = scanner.nextInt();
                System.out.println( "正方形面积:" + Math.pow(width, 2));
            } else if (square == 4) {
                System.out.println("请输入半径:");
                double height = scanner.nextInt();
                System.out.println("圆形面积:" + Math.pow(height, 2) * Math.PI);
            } else if (square == 5) {
                flag = false;
                scanner.close();
                System.out.println("结束使用");
            }
        }
    }
}