package Demo02;

import java.util.Scanner;

//10.输入整数 x，若 x 大于 0，y=1；若 x 等于 0，y=0；否则，y=-1，最后输出 y。
public class Demo10 {

    public static void main(String[] args){

        int y=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入x值:");
        int x = scanner.nextInt();

        scanner.close();

        if(x>0){
            y=1;
        }else if (x==0){
            y=0;
        }else{
            y=-1;
        }

        System.out.println("y="+y);

    }
}
