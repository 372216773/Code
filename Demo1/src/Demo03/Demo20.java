package Demo03;

import java.util.Scanner;

//20.一个 5 位数，判断它是不是回文数。即 12321 是回文数，个位与万位相同，十位与千位相同。
public class Demo20 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个五位数:");
        int num = scanner.nextInt();

        scanner.close();

        if((num/10000)==(num%10)&&((num/1000)%10)==((num%100)/10)){
            System.out.println(num+"是回文数");
        }

    }

}
