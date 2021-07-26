package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
* 杨辉三角
* */

public class T2 {

    public static List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return null;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        for(int i  = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            curList.add(1);
            for(int j = 1; j < i; j++) {
                curList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
            curList.add(1);
            list.add(curList);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        for (List<Integer> list1 : list) {
            System.out.println(list1.toString());
        }
    }

}
