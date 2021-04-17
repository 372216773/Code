import java.util.Scanner;

/**
 * 密码登录,三次机会
 */
public class Demo6 {
    public static void main(String[] args) {
        int count=3;
        while(count!=0) {
            Scanner scanner =new Scanner(System.in);
            String password=scanner.next();
            if(password.equals("123")) {
                System.out.println("登陆成功");
                break;
            }else{
                count--;
                System.out.println("密码错误!你还有"+count+"次机会!");
            }
        }
        if(count==0) {
            System.out.println("三次机会已用尽,请联系管理员进行修改!");
        }
    }
}
