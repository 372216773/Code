import java.util.HashMap;

class Solution {
    public static int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        initMap(map);
        //拿到字符串的长度
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length; ) {
            if (i + 1 < length && map.containsKey(s.substring(i, i + 2))) {
                res += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                res += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return res;
    }

    public static void initMap(HashMap<String, Integer> map) {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    public static void main(String[] args) {
        String str = "LVIII";
        System.out.println(romanToInt(str));
    }
}