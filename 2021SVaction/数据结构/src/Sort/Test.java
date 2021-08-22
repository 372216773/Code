package Sort;

import Sort.MergeSort.MergeSort;

public class Test {
    public static void main(String[] args) {
        int array[] = {8,4,5,7,1,3,6,2};

        //1.选择排序
        //SelectionSort.selectionSort(array);
        //2.归并排序
        MergeSort.mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
