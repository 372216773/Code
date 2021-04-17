package Demo03;


//24.输出 1-100 中所有的数字若包含 7（数字中有 7，或者能被 7 整除）则输出为*，否则正常输
//出数字
public class Demo24 {

    public static void main(String[] args){

        for (int i = 1; i <= 100 ; i++) {
            if(i%7==0||i%10==7||i/10==7){
                System.out.print("* ");
            }else{
                System.out.print(i+" ");
            }
            if(i%10==0){
                System.out.println();
            }
        }

    }

}
