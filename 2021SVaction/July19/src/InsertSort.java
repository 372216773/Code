/**
 * 插入排序思路:
 *1. 将第2个元素插入前面的有序序列
 *2. 将第3个元素插入前面的有序序列
 * ......
 * 一共进行n - 1次,将第n个元素插入之前的有序序列
 *
 */
public class InsertSort {

    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            //因为在j之前都是已经排好序的,所以一旦(array[j] > array[j + 1])条件不成立,就不必再循环
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                    swap(array, j, j + 1);
            }
        }
    }


    public static void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void show(int[] array) {
        for (int cur : array) {
            System.out.printf("%d\t",cur);
        }
    }

    public static void main (String[] args) {
        int[] array = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };

        insertionSort(array);
        show(array);

    }

}
