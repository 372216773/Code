package Demo04;

import java.util.Scanner;

//2.求一个 3*3 矩阵对角线元素之和
public class Demo2 {

    public static void main(String[] args){

        int[][] arrays = new int[3][3];
        int sum=0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入这个3×3的矩阵:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                    arrays[i][j] = scanner.nextInt();
                }
            }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==j||(i+j==2)){
                    sum += arrays[i][j];
                }
                    System.out.print(arrays[i][j]+" ");
                }
                System.out.println();
            }
        System.out.println("对角线之和为:"+sum);
        }

    }


