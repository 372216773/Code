package LeetCode;
//反转字符串
/*
给一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体右移到右半区，右半区整体移动到左边。
 */
import java.util.Scanner;
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String str = scanner.next();
        int len = str.length();
        str = reverseK(str, 0, k - 1);
        str = reverseK(str, k, len - 1);
        str = reverseK(str, 0, len - 1);
        System.out.println(str);
        scanner.close();
    }

    public static String reverseK(String str, int left, int right) {
        char[] ch = str.toCharArray();
        while(left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left ++;
            right --;
        }
        return new String(ch);
    }
}