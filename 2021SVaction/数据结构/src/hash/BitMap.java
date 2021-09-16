package hash;

/*
bitMap
用整型数据来表示bit数组
 */
public class BitMap {
    public static void main(String[] args) {

        int a = 0;
        //a 32bit

        int[] arr = new int[10];
        /*
        能表示320bit的信息
        arr[0] int 0~31
        arr[1] int 32~63
        arr[2] int 64~95
         */

        //178位的bit位为1
        arr[5] = 16384;

        int i = 178;

        //想要取得第178个bit的状态0还是1

        //找到int数组的第几个元素
        int numIndex = i / 32;
        //找到这个元素的第几个bit位
        int bitIndex = i % 32;

        //拿到第i位的状态(右移32-bitIndex)位到最右侧
        int s = ((arr[numIndex] >> (32 - bitIndex)) & 1);
        System.out.println("第i位的状态: " + s);
        int bit = (arr[i / 32] >> (i % 32));

        //把第i位的状态改为1
        //arr[numIndex] = arr[numIndex] | ((1 << (32 - bitIndex)));
        System.out.println("第i位的状态改为1后,数据变为: " + arr[5]);
        //把i位的状态改为0
        arr[numIndex] = arr[numIndex] & (~(1 << (32 - bitIndex)));
        System.out.println("第i位的状态改为0后,数据变为: " + arr[5]);

    }
}
