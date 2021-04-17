import java.util.Scanner;

public class method {
    //再出现两次出现一次的数据中找出只出现过一次的数字:异或运算符 ^
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入要进行操作的个数:");
        int num=scanner.nextInt();
        int[] array=new int[num];
        System.out.print("输入各值:");
        for (int i = 0; i < array.length; i++) {
            array[i]=scanner.nextInt();
        }
        System.out.println(findOnce(array));
    }
    public static int findOnce(int[] array) {
        int ret=0;
        for (int i = 0; i < array.length; i++) {
            ret ^=array[i];
        }
        return ret;
    }
}
