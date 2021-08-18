package Sort.MergeSort;

//小和问题
public class nixudui {
    /*
    逆序对问题
    在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对。
     */
    public static void ni(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergesort(arr, 0, arr.length - 1);
    }

    public static void mergesort(int[] arr, int L, int R) {
        //自身比较
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        mergesort(arr, L, mid);
        mergesort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        //遍历左半段
        int p1 = L;
        //遍历右半段
        int p2 = mid + 1;
        int p = p2;
        while (p1 <= mid && p2 <= R) {
            //
            if (arr[p1] > arr[p2]) {
                for (int j = 0; j < (mid - p1 + 1); j++) {
                    System.out.println(arr[p1 + j] + ":" + arr[p2]);
                }
            }
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
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
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 5, 7, 3};
        ni(array);
    }

}
