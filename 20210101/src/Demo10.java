import java.util.Scanner;

//将一组数据奇数放前,偶数放后
public class Demo10 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("输入要进行操作的个数:");
        int num=scanner.nextInt();
        System.out.println("输入要进行操作的数:");
        int[] array=new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i]=scanner.nextInt();
        }
        swapNum(array);
        for (int i: array) {
            System.out.print(i+" ");
        }
    }
    public static void swapNum(int[] array) {
        int i=0;
        int j=array.length-1;
        int tmp;
        while(i<j) {
            while(array[i]%2!=0&&i<j) {
                i++;
            }
            while(array[j]%2==0&&i<j) {
                j--;
            }
            tmp=array[i];
            array[i]=array[j];
            array[j]=tmp;
        }
    }
}
