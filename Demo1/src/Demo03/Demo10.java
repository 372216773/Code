package Demo03;


//10.一球从 100 米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在 第 10 次落
//地时，共经过多少米？第 10 次反弹多高？
public class Demo10 {

    public static void main(String[] args){

        double height = 100;
        double distance = 0;

        for (int i = 0; i < 10; i++) {
            distance += height;
            height = height/2;

            System.out.println("第"+(i+1)+"次反弹高度:"+height+"m");
            System.out.println("一共经过"+distance+"m");
        }

    }
}
