package recursion;

import java.util.Scanner;

/*
N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列， 也不在同一条斜线上。
给定一个整数n，返回n皇后的摆法有多少种。
n=1，返回1。 n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0。 n=8，返回92。
 */
public class NQueen {

    public static class Solution1 {

        /**
         * @param n 总行数
         * @return 可行的方案
         */
        public static int num1(int n) {
            if (n < 0) return 0;
            int[] record = new int[n];
            return process(0, record, n);
        }

        /**
         * 利用递归遍历所有可能的情况
         *
         * @param i      当前行数
         * @param record 存放皇后的数组
         * @param n      总行数
         * @return 可行的方案
         */
        public static int process(int i, int[] record, int n) {
            if (i == n) {
                return 1;
            }
            int res = 0;
            //遍历每列
            for (int j = 0; j < n; j++) {
                //判断这一列是否满足皇后条件
                if (isValue(record, i, j)) {
                    //满足条件,为当前行赋值,值为列数
                    record[i] = j;
                    //当本次递归遍历到n行后,返回1,说明找到一种可行方案
                    res += process(i + 1, record, n);
                }
            }
            return res;
        }

        /**
         * @param array 存放皇后的数组
         * @param i     之前已经摆好了皇后的行数
         * @param j     列数
         * @return 当前行
         */
        public static boolean isValue(int[] array, int i, int j) {
            //遍历之前的i-1行
            for (int k = 0; k < i; k++) {
                if (array[k] == j || Math.abs(array[k] - j) == Math.abs(i - k)) {
                    return false;
                }
            }
            return true;
        }
    }

    //使用位运算,在常数问题上进行提速
    public static class Solution2 {
        public static int num1(int n) {
            if (n <= 0 || n > 32) return 0;
            //对于n来说右边都为0,左边都为1,即左边不进入运算,右边都为1,便是可以成为皇后的位置
            //n==32 upperLimit=-1:全为1,32位都可以称为皇后位置;
            //n!=32 limit为 n左边为0,右边为1
            int upperLimit = n == 32 ? -1 : (1 << n) - 1;
            return process(upperLimit, 0, 0, 0);
        }

        public static int process(int upperLimit, int colLimit, int leftLimit, int rightLimit) {
            //皇后已经摆满了,就返回1
            if (upperLimit == colLimit) return 1;

            //皇后的所有候选位置
            int pos = upperLimit & (~(colLimit | leftLimit | rightLimit));
            int res = 0;

            //当有侯选位置时,继续遍历所有可能位置
            while (pos != 0) {
                //获得最右位置上的1
                int mostRightOne = pos & (~pos + 1);
                //减去最右侧的1,(相当于从右往左遍历为1的位置)
                pos = pos - mostRightOne;
                res += process(upperLimit,
                        //列限制
                        (colLimit | mostRightOne),
                        //列的左边限制
                        (leftLimit | mostRightOne) << 1,
                        //列的右边限制
                        (rightLimit | mostRightOne) >>> 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long start = System.currentTimeMillis();
        System.out.println(Solution1.num1(n));
        long end = System.currentTimeMillis();
        System.out.println("costTime:   " + (end - start) + "ms");

        long start1 = System.currentTimeMillis();
        System.out.println(Solution2.num1(n));
        long end1 = System.currentTimeMillis();
        System.out.println("costTime:   " + (end1 - start1) + "ms");
    }
}
