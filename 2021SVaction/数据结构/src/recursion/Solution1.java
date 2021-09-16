package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

    public static List<List<String>> solveNQueens(int n) {
        if (n == 0) return null;
        List<List<String>> lists = new ArrayList<>();
        int[] record = new int[n];
        process(0, lists, record, n);
        return lists;
    }

    public static void initList(List<List<String>> record, int n) {
        for (int i = 0; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                char[] chars = new char[n];
                for (int k = 0; k < n; k++) {
                    chars[k] = '.';
                }
                String s = Arrays.toString(chars);
                list.add(s);
            }
            record.add(list);
        }
    }

    /**
     * @param i      当前行数
     * @param record 存放方案的list
     * @param n      总行数
     */
    public static void process(int i, List<List<String>> lists, int[] record, int n) {
        if (i == n) return;
        for (int j = 0; j < n; j++) {
            if (isValue(record, i, j)) {
                //符合条件
                record[i] = j;
                process(i + 1, lists, record, n);
            }
        }
    }

    /**
     * @param record 列表
     * @param i      当前行数
     * @param j      当前列数
     * @return 是否符合条件
     */
    private static boolean isValue(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[i] - j) == Math.abs(i - k)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list: lists) {
            System.out.println(list);
        }

    }
}
