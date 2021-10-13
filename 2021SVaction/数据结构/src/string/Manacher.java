package string;

/*
Manacher算法解决的问题
字符串str中，最长回文子串的长度如何求解？
如何做到时间复杂度O(N)完成？
122131221
做法与经典方法相同,只是加速了匹配过程

经典解法:
拿到一个元素往外扩,但是像: 1221
这样会忽略偶数回文子串
改进:
加上特殊字符
#1#2#2#1#3#1#2#2#1#
可以找到奇回文和偶回文
这和"#"可以为任意字符,不做特殊要求,和源字符串中字符无关,不会有影响
时间复杂度:O(n²)
 */
public class Manacher {

    /**
     *
     * @param s 原字符串
     * @return 最长回文字符串长度
     */
    public static int maxLcpsLength(String s) {
        //1221-->#1#2#2#1#
        char[] str = manachersString(s);
        //存放回文半径的数组,至少不用验证的区域
        int[] pArr = new int[str.length];
        //取得最右回文右边界的中心位置
        int C = -1;
        //回文最右边界再往右一个位置,最右边的有效区是R-1位置
        int R = -1;
        //最大回文半径
        int max = Integer.MIN_VALUE;

        //每个位置都求回文半径
        for (int i = 0; i < str.length; i++) {
            /*
            1).R <= i i在R外 ( )i         区域为1,无优化,直接扩
            2).R > i
                ①. ( [ i'  )    ( i )] 区域为i~R
                ②.   [ ( i' )  ( i ) ] 区域为i`区域
                ③.   [( i' )    ( i )] 区域为i`区域,可能会扩大
            i`的区域与(R-i)作比较
            C - (i - C) ==> 2C-i
             */
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1; //至少不用验的回文区域

            //基于不用验的回文区域,都往外扩,范围要卡住,为整个字符串的长度
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                //左边界与右边界比较
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    //回文半径+1
                    pArr[i]++;
                } else {
                    break;
                }
            }

            //更新C,R,为了提高效率,在R范围内就可以提高效率,不在就要一个一个的扩
            if (i + pArr[i] > R) {
                C = i;
                R = i + pArr[i];
            }

            //每次扩完后,更新回文长度
            max = Math.max(max, pArr[i]);
        }
        //最大回文长度为最大回文半径-1
        return max - 1;
    }

    /**
     * 1221-->#1#2#2#1#
     *
     * @param s 原字符串
     * @return 加完特殊字符的字符串
     */
    private static char[] manachersString(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return result;
    }

}
