package Demo;

public class sparseArray {

    public static void main(String[] args) {
        /*创建原始的二维数组 11*11
        * 0 : 没有棋子 1 : 黑子 2 蓝子
        * */
        int[][] chessArray1 = new int[11][11];

        //第2行第3列有一个黑子
        chessArray1[1][2] = 1;

        //第3行第4列有一个蓝子
        chessArray1[2][3] = 2;
        //第5行第6列有一个蓝子
        chessArray1[4][5] = 2;

        //原二维数组
        System.out.println("原始二维数组:\n");

        for (int[] array : chessArray1) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                System.out.printf("%d\t", array[j]);
            }
            System.out.println();
        }

        //得到不同值的个数
        int sum = 0;

        for (int[] array : chessArray1) {
            for (int j = 0; j < chessArray1[0].length; j++){
                if (array[j] != 0){
                    sum++;
                }
            }
        }

        //定义稀疏数组,第一行用来记录二维数组行列数,以及不同值的个数
        int[][] sparseArray = new int[sum + 1][3];

        //不同值存入稀疏数组,从第二行开始
        int count = 1;

        //为稀疏数组赋值
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;

        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++){
                if (chessArray1[i][j] != 0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                    count ++;
                }
            }
        }

        System.out.println();
        //输出稀疏数组
        System.out.println("稀疏数组:");
        for (int[] array : sparseArray) {
            for (int i = 0; i < 3; i++) {
                System.out.printf("%d\t",array[i]);
            }
            System.out.println();
        }

        //恢复原二维数组

        //定义二维数组
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //为二维数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println();
        //输出回复后的二维数组
        System.out.println("恢复后的数组:");
        for (int[] array: chessArray2) {
            for (int i = 0; i < chessArray2[0].length; i++) {
                System.out.printf("%d\t",array[i]);
            }
            System.out.println();
        }
    }

}
