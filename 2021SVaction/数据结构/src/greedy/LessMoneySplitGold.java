package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金 条，不管切成长度多大的两半，都要花费20个铜板。
一群人想整分整块金条，怎么分最省铜板?
 */
public class LessMoneySplitGold {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MinheapComparator());
        for (int num : arr) {
            priorityQueue.add(num);
        }
        int sum = 0;
        int cur = 0;
        //最后剩余一个数
        while (priorityQueue.size() > 1) {
            //取出最顶上的两个元素
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            //放入两数之和
            priorityQueue.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{10,20,30};
        System.out.println(lessMoney(array));
    }
}
