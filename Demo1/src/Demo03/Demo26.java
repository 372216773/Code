package Demo03;

import java.util.Scanner;

//26.读入 1 个整数，统计并输出该数中 2 的个数。
public class Demo26 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个数:");
        int num = scanner.nextInt();

        scanner.close();

        int con=0;

        while(num%10!=0){
            if(num%10==2){
                con++;
            }
            num = num/10;
        }
        System.out.println(con);

    }

}
