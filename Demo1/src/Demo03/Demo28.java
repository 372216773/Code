package Demo03;

//28.余额宝最近万分收益每天为 1.7 左右，假设收益恒定，则 87657 元存入余额宝，一年后有多
//少钱？提示：前一天产生的收益在后一天就要计算利息  总金额=本金 + 本金/10000 * 1.7
public class Demo28 {

    public static void main(String[] args){

        System.out.println("本金87657元存入余额宝");

        double money = 87657;
        double money_rate = 1.7;

        for (int i = 0; i < 365; i++) {
            money = money + money/10000 * money_rate;
        }

        System.out.println("一年后有"+money+"元");

    }

}
