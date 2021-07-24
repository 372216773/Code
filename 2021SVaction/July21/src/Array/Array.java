package Array;

import java.util.Arrays;

//将奇数放到数组的后边,偶数放到数组的前边
public class Array {

    public static void main(String[] args) {
        int[] array = {4,6,5,4,2,3,4,4,7,3};
        Change(array);
        System.out.println(Arrays.toString(array));
    }

    public static void Change(int[] array) {

        int left = 0;
        int right = array.length - 1;
        int evenIndex;
        int oddIndex;

        while(left < right) {
            evenIndex = array[left] % 2 != 0 ? left : 0;
            oddIndex = array[right] % 2 == 0 ? right : 0;
            if (array[left] %2 == 0) {
                left ++;
            }
            if (array[right] %2 != 0) {
                right --;
            }
            if (oddIndex != 0 && evenIndex != 0) {
                //交换
                int tmp = array[oddIndex];
                array[oddIndex] = array[evenIndex];
                array[evenIndex] = tmp;
            }
        }
    }
}
