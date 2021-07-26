package Iterator;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static List<Character> method(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String str1 = "welcome to beijing";
        String str2=  "come";
        List<Character> list = method(str1, str2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
