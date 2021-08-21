package Sort;

/*

 */
public class QuickSort {
    /*
1.0:	取最后一个数据的值做划分值,分为 [小于等于 , 大于], 中间只做好了一个数 时间复杂度O(N2)
2.0:	取最后一个数据的值做划分值,分为 [小于 , 等于 , 大于],中间做好了一堆数,小于的部分递归,大于的部分递归时间复杂度O(N2)
{1,2,3,4,5,6,7,8,9}划分值最差,只有一半的区域,只有左边的区域,如果划分之刚好为中位数,就是最好情况
3.0:	(Math.random() * (r - l + 1))随机选一个位置和r最右侧的数交换
*/
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            //记录中间等于比较数的边界
            int[] p = partition(arr, l, r);
            //左侧进行操作
            quickSort(arr, l, p[0] - 1);
            //右侧进行操作
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            //从左往右遍历数组,arr[r]为比较值
            if (arr[l] < arr[r]) {
                //令less区域外第一个数与l交换,less区域加一
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                //令more区域外第一个数与l交换,more区域加一
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //more的位置上的数是大于比较数的第一个数,交换,不会影响结果
        swap(arr, more, r);
        //记录比较数的边界
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int array[] = {8, 4, 5, 7, 1, 3, 6, 2};
        quickSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
