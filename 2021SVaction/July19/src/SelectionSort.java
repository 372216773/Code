/**
 * 由小到大
 * 选择排序思路:
 * 1. 第一个数依次与后边的数进行比较,得到较小值的下标,与第一个数进行交换
 * 2. 第二个数依次与后边的数进行比较,得到较小值的下标,与第二个数进行交换
 * ......
 * n - 1: 直到最后两个数进行比较交换,
 * 共执行n-1次,完成排序
 */
public class SelectionSort {

    public static void selectionSort (int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //i为被比较值,从0到倒数第二个数
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            //j为比较值,从i后边开始,直到最后一个数
            for (int j = i + 1; j < array.length; j++) {
                //获得最小值的下标
                minIndex = array[minIndex] > array[j] ? j : minIndex;
            }
            swap(array,i,minIndex);
        }
    }

    public static void show(int[] array) {
        for (int cur : array) {
            System.out.printf("%d\t",cur);
        }
    }

    public static void swap (int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main (String[] args) {

        int[] array = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };

        selectionSort(array);
        show(array);
    }
}
