public class exchangevalue {
    public static void main(String[] args) {
        int[] array = {10,20};
        System.out.println(array[0]+" "+array[1]);
        exchange(array);
        System.out.println(array[0]+" "+array[1]);
    }
    /** @Title
     * @Description  交换两个数的值-->利用数组作为参数传递
     * @Param [array]
     * @return void
     * @Author WJ
     * @Date 17:37 2021/1/2
    */
    public static void exchange (int[] array) {
        int tmp=array[0];
        array[0]=array[1];
        array[1]=tmp;
    }
}
