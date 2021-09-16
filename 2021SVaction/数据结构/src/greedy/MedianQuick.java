package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
一个数据流中，随时可以取得中位数
 */
public class MedianQuick {

    public static class MedianHolder {

        //从小到大
        PriorityQueue<Integer> min = new PriorityQueue<>(new MinComparator());
        //从大到小
        PriorityQueue<Integer> max = new PriorityQueue<>(new MaxComparator());

        public void addNums(int[] data) {
            for (int num : data) {
                if (max.isEmpty() || num <= max.peek()) {
                    max.add(num);
                } else {
                    min.add(num);
                }
                modifyTwoHeapSize();
            }
        }

        public void modifyTwoHeapSize() {
            if (max.size() == min.size() + 2) {
                min.add(max.poll());
            }
            if (min.size() == max.size() + 2) {
                max.add(min.poll());
            }
        }

        public Double getMedian(int[] data) {
            if (data == null) return null;
            addNums(data);
            //偶数
            if ((data.length & 1) == 0) {
                return (min.peek() + max.peek()) / 2.0;
            } else {
                return max.size() > min.size() ? max.peek() * 1.0 : min.peek() * 1.0;
            }
        }
    }

    public static class MinComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static class MaxComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        int[] data = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            data[i] = Integer.parseInt(strings[i]);
        }

        MedianHolder medianHolder = new MedianHolder();
        double median = medianHolder.getMedian(data);
        System.out.println(median);

    }
}
