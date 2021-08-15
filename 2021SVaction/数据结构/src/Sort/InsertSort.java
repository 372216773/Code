package Sort;

/*
i:0~length
做到0~i上有序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
