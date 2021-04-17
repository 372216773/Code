package src;

import java.util.Scanner;

/*
不借用任何字符串库函数实现无冗余的接收两个字符串,
然后把他们无冗余的连接起来
输入描述:
每一行包含两个字符串,长度不超过100
示例:
输入:
abc def
输出:
abcdef
 */
public class Demo1 {

    public static String func(String str) {
        String ret="";
        String[] string=str.split(str);
        for (String ss:string) {
            ret+=ss;
        }
        return ret;
    }

/*    public  static String[] mySplit(String string) {
        char[] chars=string.toCharArray();
        String[] strings=new String[chars.length];

            for (String str:strings) {
                for (char ch:chars) {
                    if (ch!=' ') {
                        str+=ch;
                    }
                }
        }
            return strings;
    }*/
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //nextLine()可以接受空格
        System.out.println(func(scanner.nextLine()));
    }
}
