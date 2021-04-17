package Demo02;

import java.util.Scanner;

//7.现在有 n 条记录（从键盘上输入），每页的记录条数是 pageSize(从键盘上输入)，显示这么多记
//        录一共需要多少页
public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这些条记录:");
        String str = scanner.nextLine();

        System.out.println("请输入每页的记录条数:");
        int pageSize = scanner.nextInt();

        char[] arrays = str.toCharArray();

        double page = (double)str.length() / pageSize;

        scanner.close();

//        System.out.println(str.length());
//        System.out.println(page);
        if (page % 1 == 0) {
            System.out.println("共需" + page + "页");
        } else {
            System.out.println("共需" + (int)(page + 1) + "页");
        }
    }
}
