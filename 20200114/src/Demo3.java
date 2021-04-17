public class Demo3 {
    public static void main(String[] args) {
        String str = "http://www.baidu.com";
        String[] split = str.split(":|//|\\.");
        for (String string:split) {
            System.out.println(string);
        }
    }
}
