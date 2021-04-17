public class Demo5 {
    //判断是否为水仙花数
    public static void main(String[] args) {
        int sum;
        int length;
        int num1;
        for (int num = 1; num < 1000000; num++) {
            num1=num;
            length=0;
            while(num1!=0) {
                num1=num1/10;
                length++;
            }
            sum=0;
            num1=num;
            while(num1!=0) {
                sum+=Math.pow(num1%10,length);
                num1=num1/10;
            }
            if(sum==num) {
                System.out.println(num+"是水仙花数");
            }
        }

    }
}
