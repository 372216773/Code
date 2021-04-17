package Demo03;

//22.海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子平均分为五份，多了一个，这只猴
//子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同
//样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有
//多少个桃子？  x = x*5+1
public class Demo22 {

    public static void main(String[] args) {

        int peach = 1;
        int con=1;
        int i=0;

        while(i<5) {
            if (peach % 5 == 1) {
                System.out.println(i+"次"+"+peach="+peach);
                peach = ((peach-1) / 5 )* 4;
                i++;
            } else {
                con++;
                peach=con;
                i = 0;
            }
        }
        System.out.println("peach=" + con);

    }
}
