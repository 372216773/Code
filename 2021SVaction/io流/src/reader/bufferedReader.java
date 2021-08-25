package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class bufferedReader {

    public static void main(String[] args) throws IOException {
        String filename = "D:\\novel.txt";

        //底层调用的是传进去的FileReader类中的方法(多态,动态绑定)
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        //按行读取
        String line;

        while((line=bufferedReader.readLine())!=null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
