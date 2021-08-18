package Sort.MergeSort;

//小和问题
public class MinSum {
    /*
    在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组 的小和。求一个数组 的小和。
    例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左 边比4小的数，1、3; 2左边比2小的数，1;
    5左边比5小的数，1、3、4、 2; 所以小和为1+1+3+1+1+3+4+2=16
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergesort(arr, 0, arr.length - 1);
    }

    public static int mergesort(int[] arr, int L, int R) {
        //自身比较
        if (L == R) return 0;
        int mid = L + ((R - L) >> 1);
        return mergesort(arr, L, mid) + mergesort(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int mid, int R) {
        int sum = 0;
        int[] help = new int[R - L + 1];
        int i = 0;
        //遍历左半段
        int p1 = L;
        //遍历右半段
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            //如果符合小和要求,获得小数和
            sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            //如果左侧数小于右侧数,左侧下标加一;否则,右侧下标加一,相等也是右侧加一,这样就直接可以知道,大于左侧数的个数
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //左侧未完
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L++] = help[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 5};
        System.out.println(smallSum(array));
    }

}
