package Sort.MergeSort;

//归并排序
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //排序
    public static void merge(int[] arr, int L, int mid, int R) {
        //定义辅助数组
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        //前半段未完
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
}
