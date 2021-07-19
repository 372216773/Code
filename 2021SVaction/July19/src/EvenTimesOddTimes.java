import java.util.Scanner;

/**
 * 异或运算的性质与扩展
 * 1）0^N == N N^N == 0
 * 2）异或运算满足交换律和结合率
 * 3）不用额外变量交换两个数
 * 4）一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
 * 5）一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
 */
public class EvenTimesOddTimes {

    //一个数组中有一种数出现了奇数次，其他数都出现了偶数次，找到这一个数
    public static void printOddTimesNum1 (int[] array) {
        //用来与数组中的所有数进行异或运算,利用异或的性质0^N == N N^N == 0
        int eor = 0;
        for (int cur : array) {
            eor ^= cur;
        }

        System.out.println("那个出现了奇数次的一个数是: " + eor);
    }

    //一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
    public static void printOddTimesNum2 (int[] array) {
        //用来与数组中的所有值进行异或运算
        int eor = 0;
        int eor1 = 0;

        //得到两个数的异或
        for (int cur : array) {
            eor ^= cur;
        }

        //获得eor最右端一位上为1的数,eor这个位上为1,说明那两个数在这一位上是不同的值,分别为0和1
        int rightOne = eor & (~eor + 1);

        for (int cur : array) {
            //这个有一位为1的数(rightOne)与数组中的所有数进行与运算(&),筛选出这一位上为1的数
            if ((rightOne & cur) != 0){
                //再与其进行异或运算,筛选出出现奇数次的数,也就是两个数中的其中一个
                eor1 ^= cur;
            }
        }
        //此时eor1为其中一个数,eor为这两个数的异或,那么(eor ^ eor1)就为另一个数
        System.out.println("其中一个数为: " + eor1 + "另一个数为: " + (eor ^ eor1));

    }
    
    public static void main (String[] args) {

        int[] array1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };

        int[] array2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };

        printOddTimesNum1(array1);
        printOddTimesNum2(array2);

    }
}
