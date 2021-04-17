import java.util.Scanner;

/*
给定字符串,判断其是否全部由数字所组成
思路:将字符串变为字符数组而后判断每一位字符是否是"0"~"9"之间的内容,如果是则为数字
 */
public class Demo {
    public static boolean is(String str) {
        /*char[] chr= str.toCharArray();
        char[] chr1={'0','1','2','3','4','5','6','7','8','9'};
        boolean flag;
        for (char c : chr) {
            flag = false;
            for (char c1:chr1) {
                if (c == c1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;*/
        char[] chars=str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if (ch<'0'||ch>'9') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(is(str));

    }
}
