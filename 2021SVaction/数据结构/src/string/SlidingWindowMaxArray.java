package string;

import java.util.LinkedList;

/*
由一个代表题目，引出一种结构
【题目】
有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时:
[4 3 5]4 3 3 6 7
4[3 5 4]3 3 6 7
4 3[5 4 3]3 6 7
4 3 5[4 3 3]6 7
4 3 5 4[3 3 6]7
4 3 5 4 3[3 6 7]
窗口中最大值为5 窗口中最大值为5 窗口中最大值为5 窗口中最大值为4 窗口中最大值为6 窗口中最大值为7
如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值。
请实现一个函数。 输入:整型数组arr，窗口大小为w。
输出:一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的 以本题为例，结果应该
返回{5,5,5,4,6,7}。

窗口只能右边界或左边界向右滑的情况下，维持窗口内部最大值或者最小值快速更新的结构
窗口内最大值与最小值更新结构的原理与实现
 */
public class SlidingWindowMaxArray {

    /**
     * @param arr 整形数组
     * @param w   窗口大小
     * @return 包含每个窗口最大值的数组
     */
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) return null;
        //存放每个窗口的最大值
        int[] res = new int[arr.length - w + 1];
        //存放下标
        LinkedList<Integer> list = new LinkedList<>();
        //遍历最大值数组
        int index = 0;
        //遍历原数组
        for (int i = 0; i < arr.length; i++) {
            //如果array[i] >= array[队尾元素],弹出该队尾元素
            if (!list.isEmpty() && arr[list.peekLast()] >= arr[i]) {
                list.pollLast();
            }
            //R右移
            list.addLast(i);
            //遍历到i时会出现最大值失效(过期)的问题(这个下标已经不在窗口内)
            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }
            //遍历的元素够窗口大小后,直接赋最大值
            if (i >= w - 1) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }

    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> qmax;

        public WindowMax(int[] a) {
            this.arr = a;
            this.L = -1;
            this.R = 0;
            qmax = new LinkedList<>();
        }

        //R右移
        public void addNumFromRight() {
            if (R == arr.length) return;
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) qmax.pollLast();
            qmax.addLast(R);
        }

        //L右移
        public void removeNumFromLeft() {
            if (L >= R - 1) return;
            L++;
            if (qmax.peekFirst() == L) qmax.pollFirst();
        }

        public Integer getMax() {
            if (!qmax.isEmpty()) return arr[qmax.peekFirst()];
            return null;
        }
    }

}
