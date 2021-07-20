package Demo;

import java.util.Scanner;

public class maze {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入棋盘大小:");
        System.out.print("length:");
        int length = scanner.nextInt();
        System.out.print("width:");
        int width = scanner.nextInt();

        //棋盘大小,加的1是墙
        int[][] array = new int[length + 2][width + 2];

        //0 代表未探索区域; 1 代表围墙; 2 代表 已探索过; 3 代表此路不通

        //设置边界
        for (int i = 0; i <= length + 1; i++) {
            for (int j = 0; j <= width + 1; j++) {
                //上边界
                array[0][j] = 1;
                //下边界
                array[length + 1][j] = 1;
                //左边界
                array[i][0] = 1;
                //右边界
                array[i][width + 1] = 1;
            }
        }

        System.out.println("原始地图:");
        showMap(array);

        System.out.println("请输入障碍数量:\t");
        int hinderNum = scanner.nextInt();
        System.out.println("请输入坐标来设置障碍");

        for (int i = 0; i < hinderNum; i++) {
            System.out.print("row:");
            int row = scanner.nextInt();
            System.out.print("column:");
            int column = scanner.nextInt();
            //加上边界的偏移量
            array[row + 1][column + 1] = 1;
            System.out.println("---------");
        }

        System.out.println("设置成功的地图:");
        showMap(array);

        //设置终点
        System.out.println("请设置初始坐标和终点坐标:");
        System.out.print("initialRow:");
        int initialRow = scanner.nextInt() + 1;
        System.out.print("initialColumn:");
        int initialColumn = scanner.nextInt() + 1;
        System.out.print("finalRow:");
        int finalRow = scanner.nextInt() + 1;
        System.out.print("finalColumn:");
        int finalColumn = scanner.nextInt() + 1;

        //do it
        findWay(array, initialRow, initialColumn, finalRow, finalColumn);
        //showMap(array);

    }

    public static void showMap (int[][] array) {
        for (int[] array1 : array) {
            for (int cur : array1) {
                System.out.print(cur + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    //需要棋盘,初始坐标,终点坐标
    public static boolean findWay (int[][] array, int row, int column, int finalRow, int finalColumn) {
        //已走到终点
        if (array[finalRow][finalColumn] == 2) {
            return true;
        }
        //在未走过的路上找路(即坐标值不为2,3即可)
        if (array[row][column] == 0) {
            //如果走过设为2
            array[row][column] = 2;
            showMap(array);

            //行走策略: 下右上左
            //进行回溯,即进入一个分支进行递归,发现走不通,返回false,就又回来走另一条路,即执行下一条语句
            if (findWay(array, row + 1, column, finalRow, finalColumn)) {
                //其实不会进if语句中执行return true语句,因为如果判断这条路走过,即为2,
                //或者这条路为死路,即为3,就直接进行else if的判断了
                return true;
            } else if (findWay(array, row, column + 1, finalRow, finalColumn)) {
                return true;
            } else if (findWay(array, row - 1, column, finalRow, finalColumn)) {
                return true;
            } else if (findWay(array, row, column - 1, finalRow, finalColumn)) {
                return true;
            } else {
                //所有路都走不通,为死路,设置为3,会回溯到上一步
                array[row][column] = 3;
                return false;
            }
        }else {
            //如果坐标上的值不为0,即这个位置已走过,或是墙,就返回false,换条路
            return false;
        }
    }
}
