package Demo04;

import java.util.Scanner;

//6.有 n 个整数，使其前面各数顺序向后移 m 个位置，最后 m 个数变成最前面的 m 个数
public class Demo6 {

    public static void main(String[] args){



        Scanner scanner = new Scanner(System.in);

        System.out.println("输入n值:");
        int n = scanner.nextInt();
        System.out.println("输入这"+n+"个整数");

        int t;
        int[] arrays = new int[n];

        for (int i = 0; i < n; i++) {

            arrays[i] = scanner.nextInt();

        }
        System.out.println("输入m值:");
        int m = scanner.nextInt();

        for (int i = 0,j=n-1; i < j; i++,j--) {
            t=arrays[i];
            arrays[i]=arrays[j];
            arrays[j]=t;
        }

        for (int i = 0,j=m-1; i < j; i++,j--) {

            t=arrays[i];
            arrays[i]=arrays[j];
            arrays[j]=t;

        }

        System.out.println();
        for (int i = m,j=n-1; i < j; i++,j--) {
            t=arrays[i];
            arrays[i]=arrays[j];
            arrays[j]=t;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arrays[i]+" ");

        }


    }

}
