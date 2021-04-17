package Rectangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入width:");
        int width=scanner.nextInt();
        System.out.println("请输入height:");
        int height=scanner.nextInt();

        scanner.close();

        Rectangle recA=new Rectangle(3,4);
        recA.Change(width,height);
        recA.ShowInformation();
        recA.area();
    }
}
