package Sort.HeapSort;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK {

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //将k个数放入到优先队列中,会自动排好序,从小到大
        for (; index < k; index++) {
            heap.add(arr[index]);
        }

        //再往后的数,先加到小根堆中,会进行排序,然后再加到数组中
        //当index=arr.length时,即剩余数组中的数全在小根堆中
        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            //弹出首元素
            arr[i] = heap.poll();
        }

        //将小根堆中剩余的数全放到数组中
        while (i<arr.length) {
            arr[i++] = heap.poll();
        }

    }

}
