package Demo01;
//4. 求1~1000以内质数列表
public class Demo4 {
    public static void main(String[] args) {
        int j=0;
        for (int i = 2; i <= 1000; i++) {
            for (j = 2; j < i&&(i%j!=0); j++);
            if (j>=i) {
                System.out.println(i + " ");
            }
        }
    }
}
