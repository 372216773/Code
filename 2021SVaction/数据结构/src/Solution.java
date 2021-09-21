import java.util.Arrays;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        for (int i = strings.length - 1; ; ) {
            return strings[i].length();
        }
    }

    public static void main(String[] args) {
        String tst = " Google Runoob Taobao Facebook   ";
        //如果字符串前后有空格则会返回新的字符串
        String str = "a";
        System.out.println(str.length());
        System.out.println(tst.trim());
    }
}