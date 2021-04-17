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
                Integer integer = outerList.get(i-1).get(j-1);
                //获得i-1层的第j个数
                Integer integer1 = outerList.get(i-1).get(j);
                //赋值给i层的第j个数
                innerList.set(j,integer+integer1);
            }

        }
        return outerList;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = generate(6);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
