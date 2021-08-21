package Sort.HeapSort;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
       /* for (int i = 0; i < arr.length - 1; i++) {//O(N)
            //每个数都进行向上换,数组整体为大根堆
            heapInsert(arr, i);//O(logN)
        }*/
        for (int i = arr.length-1; i >0; i--) {
            heapify(arr,i,arr.length);
        }
        int heapSize = arr.length;

        swap(arr, 0, heapSize - 1);//O(1)
        while (heapSize > 0) {//O(N)
            //从根开始,往下找出最大值,放在0号位置
            heapify(arr, 0, heapSize--);//O(logN)
            swap(arr, 0, heapSize);//O(1)
        }
    }

    //向上比较
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //向下比较
    public static void heapify(int[] arr, int index, int size) {

        //节点的左节点
        int left = index * 2 + 1;
        while (left < size) {
            //如果最后只有左节点,最大值就暂为左节点
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;

            //父节点符合小根堆定义,不用交换
            if (index == largest) {
                break;
            }

            //不满足条件,交换
            swap(arr, index, largest);

            //遍历条件
            left = index * 2 + 1;
        }
    }

    public static void main(String[] args) {

        int array[] = {8, 4, 5, 7, 1, 3, 6, 2};

        heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
