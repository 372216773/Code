package OJ.YangHuiSanJiao;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> outerList = new ArrayList<>();
        /*for (int i = 0; i < numRows; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    inner.add(1);
                } else {
                    Integer integer1 = outerList.get(i - 1).get(j - 1);
                    Integer integer2 = outerList.get(i - 1).get(j);
                    inner.add(1,integer1+integer2);
                }
            }
            outerList.add(inner);
        }*/
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                innerList.add(1);
            }
            outerList.add(innerList);
        }
        //从第三层开始
        for (int i = 2; i < outerList.size(); i++) {
            List<Integer> innerList = outerList.get(i);
            for (int j = 1; j < innerList.size() - 1; j++) {
                //获得i-1层的第j-1个数
                Integer integer = outerList.get(i - 1).get(j - 1);
                //获得i-1层的第j个数
                Integer integer1 = outerList.get(i - 1).get(j);
                //赋值给i层的第j个数
                innerList.set(j, integer + integer1);
            }

        }
        return outerList;
    }

    public static ArrayList<ArrayList<Integer>> generate1(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list1.add(1);
                } else {
                    Integer num1 = list.get(i - 1).get(j - 1);
                    Integer num2 = list.get(i - 1).get(j);
                    list1.add(num1 + num2);
                }
            }
            list.add(list1);
        }
        return list;
    }

    /**
     * 给出一个索引k，返回杨辉三角的第k行
     *
     * @param rowIndex 行数 从0开始
     * @return 第rowIndex行的数据
     */
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        if (rowIndex < 0)
            return row;
        row.add(1);
        //
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }

    /**
     * 给出一个索引k，返回杨辉三角的第k行
     *
     * @param rowIndex 行数 从0开始
     * @return 第rowIndex行的数据
     */
    public static ArrayList<Integer> getRow1(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        if (rowIndex < 0) return list;
        //为第一个和第二个进行赋值
        list.add(1);
        list.add(1);
        //除过第一个数,其他位置的数进行如下操作
        //list[i] = list[i]+list[i-1];
        for (int i = 1; i < rowIndex; i++) {
            //第i个数等于i-1加上i,每增加一个数,i之前的所有数都需要进行此操作
            for (int j = i; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
            //每次进行完操作后,后边加上一个元素,元素值为1
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = generate1(6);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        //System.out.println(getRow(3));
        System.out.println(getRow1(3));
    }

}
