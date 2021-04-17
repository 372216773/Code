package Demo04;

import java.util.Scanner;

//5.输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
public class Demo5 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个数组的大小");
        int num = scanner.nextInt();

        int[] arrays = new int[num];
        int t;
        int max=0;
        int min=0;

        System.out.println("请输入这个数组:");
        for (int i = 0; i < num; i++) {
            arrays[i] = scanner.nextInt();
        }

        scanner.close();


        for (int i = 0; i < num; i++) {
            if (arrays[i]>arrays[max]){

                max = i;

            }
            if (arrays[i]<arrays[min]){

                min = i;

            }
        }
        t = arrays[max];
        arrays[max] = arrays[0];
        arrays[0] = t;

        t = arrays[min];
        arrays[min] = arrays[num-1];
        arrays[num-1] = t;

        for (int i = 0; i < num; i++) {
            System.out.print(arrays[i]+" ");
        }

    }

}
