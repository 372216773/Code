import java.util.Scanner;

public class StringDemo {
    //输入一个整数k,将一个字符串的前k个字符挪到右边
    public static String reverseK (String str,int k) {
        //考虑全面-->情况
        if (str==null||k<=0||k>=str.length()) {
            return null;
        }
        str=reverse(str,0,k-1);
        str=reverse(str,k,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }

//逆置字符串
    public static String reverse(String str,int begin,int end) {
        char[] chars=str.toCharArray();
        char ch;
        while (begin<=end) {
            ch=chars[begin];
            chars[begin]=chars[end];
            chars[end]=ch;
            begin++;
            end--;
        }
        //返回的是带有[,,,]的形式的字符串
        //return Arrays.toString(chars);
        //只返回字符串
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int k=scanner.nextInt();
        String str=scanner.next();
        //length:从1开始
       //System.out.println(str.length());
        //System.out.println(reverse(str,0,str.length()-1));
        System.out.println(reverseK(str,k));
    }
}
