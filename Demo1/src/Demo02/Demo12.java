package Demo02;

import java.util.Scanner;

//12.输入三个整数 x,y,z，请把这三个数由小到大输出。
public class Demo12 {

    public static void main(String[] args){

        int t=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入整数x");
        int x = scanner.nextInt();
        System.out.println("请输入整数y");
        int y = scanner.nextInt();
        System.out.println("请输入整数z");
        int z = scanner.nextInt();

        scanner.close();

        if(x>y){
            t=y;
            y=x;
            x=t;
        }
        if(y>z){
            t=y;
            y=z;
            z=t;
        }
        if(x>z){
            t=z;
            z=x;
            x=t;
        }

        System.out.println(x+" "+y+" "+z);

    }
}
