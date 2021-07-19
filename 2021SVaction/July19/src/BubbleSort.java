/**
 * 由小到大
 * 冒泡排序思路:
 *1. 依次比较0和1、1和2、2和3...（n-2）和（n-1）索引的元素，如果发现第1个数据大于第2个数据，交换他们，经过第1趟排序，0~n-1中最大的元素排到了最后
 *2. 依次比较0和1、1和2、2和3...（n-3）和（n-2）索引的元素，如果发现第1个数据大于第2个数据，交换他们，经过第1趟排序，0~n-2中最大的元素排到了倒数第二个
 * ......
 * n - 1: 直到第一个数和第二个数比较交换
 * 共执行n - 1次,完成排序
 */
public class BubbleSort {

    public static void bubbleSort (int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, i ,j);
                }
            }
        }
    }

    public static void bubbleSortPlus (int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        //减少外层循环次数,例: [8, 7, 6, 1, 2, 3, 4, 5]
        //如果该次循环没有发生交换，就说明数组已经排好序了，那么后面的循环比较就可以停止了
        boolean flag = true;
        //记录最后一次交换的位置
        int lastIndex = 0;
        //卡内层循环区间,减少内层循环次数.例: [2, 4, 3, 1, 5, 6, 7, 8, 9]
        //将出现不再交换数据时的位置下标找到，然后把这个下标值作为内层循环j的右区间。就会减少比较次数
        int k =  array.length - 1;
        for (int i = array.length - 1; i > 0 && flag; i--) {
            flag = false;
            for (int j = 0; j < k; j++) {
                /*
                如果进行了交换,将最后一个交换过的值下标j作为右区间(因为在这之后的值没有进行交换,说明已排好了序)
                没有进行交换说明已排好序了,flag的值没有改变,还是false,就不会进行下次循环
                 */
                if (array[j] > array[j + 1]) {
                    flag = true;
                    lastIndex = j;
                    swap(array, j ,j + 1);
                }
            }
            //重新设置区间大小
            k = lastIndex;
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

        //bubbleSort(array);
        bubbleSortPlus(array);
        show(array);

    }
}
