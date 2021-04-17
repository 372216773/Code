package Demo01;

import java.util.Scanner;

//5.现在有 n 条记录（从键盘上输入），每页的记录条数是 pageSize(从键盘上输入)，计算出这么多
//        记录是几页，另外还剩余几条记录
public class Demo5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这些条记录:");
        String str = scanner.nextLine();

        System.out.println("请输入每页的记录条数:");
        int pageSize = scanner.nextInt();

        char[] arrays = str.toCharArray();

        int page = str.length()/pageSize;
        int last_page = str.length()/pageSize;

        scanner.close();

        System.out.println(str.length());
        System.out.println("共为"+page+"页");
        System.out.println("还剩余"+last_page+"页");
    }
}
