import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int flag = 1;
        while (flag != 0) {
            int num = scanner.nextInt();
            if (num == 0) {
                flag = 0;
                System.out.println("程序结束!");
            } else {
                System.out.println("第" + num + "个fibonacci数为:" + fibonacci(num));
                System.out.println("输入0结束!");
            }
        }

    }

    public static int fibonacci(int num) {
        int f1 = 1;
        int f2 = 1;
        int f3 = f1 + f2;
        if (num == 1 || num == 2) {
            return 1;
        }
        for (int i = 3; i <= num; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;

    }
}

