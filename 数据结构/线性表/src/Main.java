import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(method1(n,m)+method3(n,m));;

    }

    //辗转相除法求最大公约数
    public static int method1(int num1, int num2) {
        int temp = 0;
        while (num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    //求最大公约数
    public static int method2(int num1, int num2) {
        int min = Math.min(num1, num2);
        for (int i = min; i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    //两数之积 = 最小公倍数*最大公约数
    public static long method3(int num1, int num2) {
        return (long)num1 * num2 / method1(num1, num2);
    }
}