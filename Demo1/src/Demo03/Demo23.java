package Demo03;

//23.求 0—10000 所有素数之和。
public class Demo23 {
    
    public static void main(String[] args){

        int j;
        int sum=0;
//        int con=1;

        for (int i = 1; i <= 10000; i++) {
            for (j = 2; j <= Math.sqrt(i)&&(i%j!=0); j++) {}
            if(j > Math.sqrt(i)){
                //System.out.print(i+" ");
                sum += i;
//                con++;
            }
//            if (con%11==0){
//                System.out.println();
//                con =1;
            }
        System.out.println("sum="+sum);
        }
        
    }

