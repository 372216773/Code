/**
 *
 */

import java.util.Scanner;

public class Demo9 {
    //1!+2!+3!+4!+5!
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int sum=method(x);
        System.out.println(sum);
    }

    public static int method(int num) {
        int sum = 0;
        int sum1;
        for (int i = 1; i <= num; i++) {
            sum1=1;
            for (int j = 1; j <= i; j++) {
                sum1 *= j;
            }
            sum += sum1;
        }
        return sum;
    }
}
