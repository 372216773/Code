import java.util.Scanner;

/*
8
BBRBRBBR
 */
public class Main {
/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = Long.parseLong(scanner.next());
        char[] chars;
        String strings = scanner.next();
        chars = strings.toCharArray();

        System.out.println(count(chars));
    }

    public static long count(char[] chars) {
        long num = 1;
        char color = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != color) {
                num++;
            }
        }
        return num;
    }*/

/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        System.out.println(isTrue(num1, num2));
    }

    public static class Type {
        public int count;
        public boolean b;

        public Type() {
            this.count = 0;
            this.b = true;
        }
    }

    public static Type isTrue(int num1, int num2) {
        Type type = new Type();
        if (num2 < num1) {
            type.count = -1;
            type.b = false;
            return type;
        }

        boolean b = num2 % num1 == 0;

        isTrue(num1, num2 / num1);
    }*/
public static void main(String[] args) {
    Object A = new Object();
    Object B = new Object();
    new Thread(()->{synchronized (A) {
        //代码块
        synchronized (B) {
            //代码块
        }
    }},"t1");
    new Thread(()->{synchronized (B) {
        //代码块
        synchronized (A) {
            //代码块
        }
    }},"t2");
}
}
//给一个等比数列的和,求输出最多项的项数
//修改字符串的代价,将给定字符串修改为自定字符串,大写改成小写,小写改成大写,花费5,字符替换花费5,求总花费
//死锁的产生,解决死锁的方案
