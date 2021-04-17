import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num=scanner.nextInt();
        for (int i = 31; i >= 0; i--) {
            System.out.print((num>>i)&1);
        }
        System.out.println();
        for (int i = 31; i >= 1; i-=2) {
            System.out.print((num>>i)&1);
        }
        System.out.println();
        for (int i = 30; i >= 0; i-=2) {
            System.out.print((num>>i)&1);
        }
    }
}
