package Sort.xor;
/*
    异或运算的应用(无进位相加)
 */
public class xor {
    /*
    0^N=N;
    N^N=0;
    异或使用条件,必须是两块空间
    1.一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
    将所有数都进行异或
     */
    public static void findOneNum(int[] arr) {
        if (arr == null) return;
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println("This num is " + eor);
    }

    /*
    2.一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
    eor=a^b,eor在某位上为1
    eor1为某位为1的数,用来异或全部数,就可以获得a/b其中一个数
    */
    public static void findTwoNum(int[] arr) {
        if (arr == null) return;
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        //取出最右侧的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;

        for (int cur : arr) {
            if ((cur & rightOne) == rightOne) {
                onlyOne ^= cur;
            }
        }
        int otherOne = onlyOne ^ eor;
    }
}
