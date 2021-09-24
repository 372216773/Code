package Sort.BinarySearch;

/*
二分法

1）在一个有序数组中，找某个数是否存在,返回下标

2）在一个有序数组中，找>=某个数最左侧的位置

3）局部最小值问题

 */
public class BinarySearch {

    //1）在一个有序数组中，找某个数是否存在,返回下标
    //边界情况 mid不变,left-1/right+1
    public static int BSExist(int[] arr, int key) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            //left的位置加上偏移量
            mid = left + ((right - left) >> 1);
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //2）在一个有序数组中，找>=某个数最左侧的位置
    public static int BENearLeft(int[] arr, int key) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int index = -1;
        while (left < right) {
            //防止溢出(l+r溢出),速度快
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= key) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(BENearLeft(array, 4));
    }

}
