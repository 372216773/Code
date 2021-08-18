import java.util.ArrayList;

/*
java.lang.OutOfMemoryError ：java heap space. 堆内存溢出
 */
public class OutOfMemoryError {
    public static void main(String[] args) {
        int count = 0;
        try{
            ArrayList<String> list = new ArrayList<>();
            String string = "helloWorld";
            while (true) {
                list.add(string);
                string = string + string;
                count++;
            }
        }catch(Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }

}
