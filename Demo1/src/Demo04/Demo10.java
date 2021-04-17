package Demo04;

import java.util.Scanner;

//10.求两个数组的和差：就是去掉两个数组中相同的元素 然后将两个数组中的元素存放在一个新
//的数组中，且数组 A 中元素要在 B 数组元素之前
//如：输入： int[] a={1,2,4,7,6,9};
// int[] b={2,4,3,10};
// 输出： int[] c = {1, 7, 6, 9, 3, 10};
public class Demo10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数组A的元素个数:");
        int A = scanner.nextInt();
        System.out.println("请输入数组A:");
        int[] arrays_A = new int[A];
        for (int i = 0; i < A; i++) {
            arrays_A[i] = scanner.nextInt();
        }

        System.out.println("请输入数组B的元素个数:");
        int B = scanner.nextInt();
        System.out.println("请输入数组B:");
        int[] arrays_B = new int[B];
        for (int i = 0; i < B; i++) {
            arrays_B[i] = scanner.nextInt();
        }

        scanner.close();

        int len = A + B;
        int[] arrays_C = new int[len];
        //如：输入： int[] a={1,2,4,7,6,9};
        // int[] b={2,4,3,10};

        int j;
        int c=0;
        for (int i = 0; i < A; i++) {
            for (j = 0; j < B&&arrays_A[i]!=arrays_B[j]; j++) {}
            if (j==B){
                arrays_C[c++]=arrays_A[i];
            }else{
                for (int k = j; k < B-1; k++) {
                    arrays_B[k]=arrays_B[k+1];
                }B--;
                len-=2;
            }
        }
        for (int i = 0; i<B; i++) {
            arrays_C[c++]=arrays_B[i];
        }

        System.out.println("合并后数组:");
        for (int i = 0; i < len; i++) {
            System.out.print(arrays_C[i]+" ");
        }

    }
}