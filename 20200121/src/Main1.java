import java.util.Scanner;

/*
输入一个字符串,求出该字符串包含的字符集合
输入描述:
```每组```数据输入一个字符串,字符串的最大长度为100,且只包含字母,不可能为空字符串,区分大小写
---每组数据,用while循环接受数据,````输入一组数据,就输出结果``````
输出描述:
每组数据一行,找字符串原有的字符顺序,输出字符集合,及重复出现并靠后的字母不输出
 */
public class Main1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!stringBuilder.toString().contains(ch+"")) {
                    stringBuilder.append(ch);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
