package Demo04;

import java.util.Scanner;

//9.从键盘上给一个 5*5 整型数组输入值，找出对角线及边上的最大的元素，并且输出其坐标。
/*
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
 */
public class Demo9 {

    static int M = 5;
    static int N = 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入5×5整形数组的值:");

        int[][] arrays = new int[M][N];
        int max_j = 0;
        int max_x = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) == 4 || i == j) {
                    if (arrays[i][j] > arrays[max_x][max_j]) {
                        max_x = i;
                        max_j = j;
                    }
                    System.out.print(arrays[i][j] + " ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("5×5矩阵对角线最大值为:" + arrays[max_x][max_j] + " 第" + max_x + "行 第" + max_j + "列");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0 && i < 4 && j > 0 && j < 4) {
                    if (arrays[i][j] > arrays[max_x][max_j]) {
                        max_x = i;
                        max_j = j;

                    }
                    System.out.print("* ");
                } else {
                    System.out.print(arrays[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("5×5矩阵边上最大值为:" + arrays[max_x][max_j] + " 第" + max_x + "行 第" + max_j + "列");
    }

}
