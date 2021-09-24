package hash;

import java.util.Scanner;

/*
岛问题
【题目】
一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，如
果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛?
【举例】
001010
111010
100100
000000
这个矩阵中有三个岛

递归:
时间复杂度:O(M*N)

【进阶】
如何设计一个并行算法解决这个问题
 */
public class Islands {
    //单个CPU
    //递归方法
    public static int countIslands(int[][] map) {
        if (map == null || map.length == 0) {
            return 0;
        }
        //纵
        int M = map.length;
        //横
        int N = map[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    //可以作为岛的区域
                    count++;
                    infect(map, i, j, M, N);
                }
            }
        }
        return count;
    }

    private static void infect(int[][] map, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || map[i][j] != 1) return;

        //在界内,且这个区域可以作为岛屿的一部分map[i][j] == 1
        map[i][j] = 2;

        //上左下右,都设置好
        infect(map, i - 1, j, M, N);
        infect(map, i, j - 1, M, N);
        infect(map, i + 1, j, M, N);
        infect(map, i, j + 1, M, N);
    }

    //并查集
    //多个CPU

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = Integer.parseInt(scanner.next());
        int N = Integer.parseInt(scanner.next());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int islands = countIslands(map);
        System.out.println(islands);
    }
}
