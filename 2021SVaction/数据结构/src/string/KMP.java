package string;

/*
KMP算法解决的问题:是否包含子串
字符串str1和str2，str1是否包含str2，如果包含返回str2在str1中开始的位置。
如何做到时间复杂度O(N)完成？

暴力方法:时间复杂度:O(M*N)

 */
public class KMP {

    public static int getIndexOf(String s, String m) {
        //s长度小于m,肯定不满足要求
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) return -1;
        //字符串数组str1
        char[] str1 = s.toCharArray();
        //字符串数组str2
        char[] str2 = m.toCharArray();
        //用来遍历str1
        int i1 = 0;
        //用来遍历str2
        int i2 = 0;

        int[] next = getNextArray(str2);

        while (i1 < str1.length && i2 < str2.length) {
            //匹配成功
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {//str1[i1]!=str2[i2],并且i2还在str2的零号位置
                i1++;
            } else { //str1[i1]!=str2[i2],i2往回跳,i2的位置存放在next[i2]中
                i2 = next[i2];
            }
        }
        //只有匹配成功,i2才会++,如果i2越界,说明在str1中某个位置开始可以匹配出完整的str2,位置为(i1-str2的长度),也就是(i1-i2),因为i2遍历到了最后一个
        //i1越界,说明从str1任何位置开始,都没有匹配出完整的str2
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 拿到next数组
     *
     * @param ms 字符串
     * @return next数组
     */
    private static int[] getNextArray(char[] ms) {
        if (ms.length == 1) return new int[]{-1};

        //每个位置上都存放着最长前缀与最长后缀相等的长度
        int[] next = new int[ms.length];
        //0位置之前没有数据进行比较
        next[0] = -1;
        //1位置之前只有一个数,所以不满足要求
        next[1] = 0;
        //next数组位置
        int i = 2;
        //与i-1位置相比的位置
        int cn = 0;

        while (i < next.length) {
            if (ms[i - 1] == ms[cn]) {
                //next[i]=cn+1;i++;
                //cn是i-1位置的信息,cn++是i位置上的信息
                next[i++] = ++cn;
            } else if (cn > 0) { //ms[i - 1] != ms[cn],并且比较的下标cn不为0,使得cn往前跳
                cn = next[cn];
            } else { //ms[i - 1] != ms[cn],并且比较的下标为0,i-1位置上的值和0位置上的值都不相等
                next[i++] = 0;
            }
        }
        return next;
    }
}
