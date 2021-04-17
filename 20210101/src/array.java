import java.util.Arrays;

public class array {

    public static int[] changeArray(int[] array) {
        int[] array1=new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i]=array[i]*2;
        }
        return array1;
    }
    /** @Title   注意参数判断
     * @Description 找数组中的最大值
     * @Param [array]
     * @return int
     * @Author WJ
     * @Date 19:21 2021/1/2
    */
    public  static int findMaxvalue(int[] array) {
        if (array==null||array.length==0) {
            return -1;
        }
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i]>max) {
                max=array[i];
            }
        }
        return max;
    }

    /** @Title   注意参数判断
     * @Description 注意类型
     * @Param [array]
     * @return double
     * @Author WJ
     * @Date 19:25 2021/1/2
    */
    public static double findAverageValue(int[] array) {
        if (array==null||array.length==0) {
            return -1;
        }
        double aver=0;
        for (int i = 0; i < array.length; i++) {
            aver+=(double)array[i]/array.length;
        }
        return aver;
    }

    /** @Title 找出key值,返回下标
     * @Description 最坏情况下,要找length次,查找时间过慢
     * 折半查找-->二分查找
     * @Param [array, key]
     * @return int
     * @Author WJ
     * @Date 19:31 2021/1/2
    */
    public static int findIndex(int[] array,int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]==key) {
                return i;
            }
        }
        return -1;
    }

    /** @Title
     * @Description 二分查找
     * @Param [array, key]
     * @return int 
     * @Author WJ        
     * @Date 19:52 2021/1/2         
    */
    public static int binarySearch(int[] array,int key) {
        if (array==null||array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        int mid;
        while(left<=right) {
            mid=(left+right)/2;
            if (array[mid]>key) {
                right=mid-1;
            }else if (array[mid]<key) {
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /** @Title
     * @Description 注意数组的越界
     * @Param [array]
     * @return boolean
     * @Author WJ
     * @Date 20:10 2021/1/2
    */
    public static boolean isSorted(int[] array) {
        if (array==null||array.length==0) {
            return false;
        }
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /** @Title
     * @Description 冒泡排序
     * 有n个数据
     * 比较n-1次
     * 每次比较都比上次少一次
     * for (int i = 0; i < array.length-1; i++) 比较n-1次
     * for (int j = 0; j < array.length-i-1; j++) 每次比较都比上次少一次
     * if (flag==false) {//优化,在这之中如果有一趟未进行排序,则代表已排好序,则直接退出
     * return ;
     * }
     * @Param [array]
     * @return void
     * @Author WJ
     * @Date 20:13 2021/1/2
    */
    public static void bubbleSort(int[] array) {
        int tmp;
        boolean flag;
        for (int i = 0; i < array.length-1; i++) {//比较的次数
            flag=false;
            for (int j = 0; j < array.length-i-1; j++) {//每次比较过程
                if (array[j]>array[j+1]) {
                    tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=true;
                }
            }
            if (!flag) {//优化,在这之中如果有一趟未进行排序,则代表已排好序,则直接退出
                return ;
            }
        }
    }

    public static void reverse1(int[] array) {
        int i=0;
        int j=array.length-1;
        int tmp;
        while(i<j) {
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
            i++;
            j--;
        }
    }

    /** @Title 还没写出来
     * @Description 递归顺序,递归逆序,递归实现数组的逆置
     * @Param [array]
     * @return void
     * @Author WJ
     * @Date 21:06 2021/1/2
    */


    public static void main(String[] args) {
        int[] array ={5,4,3,2,1};
        int[] array1=changeArray(array);
        //System.out.println(Arrays.toString(array1));
        System.out.println(findMaxvalue(array));
        System.out.println(findAverageValue(array));
        System.out.println(findIndex(array,3));
        System.out.println(binarySearch(array,3));
        System.out.println(Arrays.binarySearch(array,3));
        System.out.println(isSorted(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
