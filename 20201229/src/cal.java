import java.util.Scanner;

/**
 *
 */
public class cal {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入值:");
        int a=scanner.nextInt();
        int odd=0;
        int eve=0;
        while(a>0) {
            if(a%2==0) {
                odd+=a;
            } else {
                eve+=a;
            }
            a--;
        }
        System.out.println("奇数和:"+odd);
        System.out.println("偶数和:"+eve);
        int t=5;
        int total=0;
        int total1=1;
        int i;
        while(t>0) {
            i=1;
            total1=1;
            while(i<=t) {
                total1*=i;
                i++;
            }
            t--;
            total+=total1;
        }
        System.out.println(total);
    }
}
