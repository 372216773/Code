package Demo03;

//17.求 1+2!+3!+...+20!的和
public class Demo17 {

    public static void main(String[] args){

        long sum = 1;
        long mul;
        System.out.print("1");
        for (int i = 2; i < 21; i++) {
            mul=1;
            for (int j = 1; j <= i; j++) {

                mul = mul*j;

            }
            sum += mul;
            System.out.print("+"+i+"!");
        }
        System.out.println("\n"+"sum="+sum);

    }

}
