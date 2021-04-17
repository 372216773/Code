import java.util.Scanner;

/**
 * 写一个函数返回参数二进制1的个数,比如:15 0000 1111 返回:4个1
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int count=0;
        while(num!=0) {
            count++;
            num=num&(num-1);
        }
        System.out.println("有"+count+"个1");
    }
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int count=0;
        for (int i = 0; i < 31; i++) {
            if(((num>>>i)&1)!=0){//>>>右移,且左边补零
                count++;
            }
        }
        System.out.println(count);
    }
}

