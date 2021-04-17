package Demo01;

import java.util.Scanner;

//5. 定义一个数组int[] nums={8,7,3,9,5,4,1}, 输出数组中的最大值和最大值所在的下标
//数组可以由学生输入
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数组的大小:");
        int size=scanner.nextInt();
        int[] a=new int[size];
        for (int i = 0; i < size; i++) {
            a[i]=scanner.nextInt();
        }
        int max,maxj;
        max=a[0];
        maxj=0;
        for (int i = 1; i < size; i++) {
            if(a[i]>max){
                max=a[i];
                maxj=i;
            }
        }
        System.out.println("最大值为:a["+maxj+"]="+max);
    }
}
