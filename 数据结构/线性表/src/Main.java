import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = str.length();
        int num = Integer.parseInt(str);
        int result = 0;
        while ((length--)>0) {
            int num1 = ((num / (int) Math.pow(10, length)) % 2 == 0) ? 0 : 1;
            result = result * 10 + num1;
            num = num %(int) Math.pow(10,length);
        }
        System.out.println(result);
    }
}