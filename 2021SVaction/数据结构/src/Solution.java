import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= s.length() - 10; i++) {
            String string = s.substring(i,i+10);
            if (map.containsKey(string)) {
                map.put(string,map.get(string)+1);
            } else {
                map.put(string,1);
            }
            if (map.get(string) >=2) list.add(string);
        }
        return list;
    }
}