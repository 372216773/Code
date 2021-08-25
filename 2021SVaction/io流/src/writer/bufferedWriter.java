package writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bufferedWriter {
    public static void main(String[] args) throws IOException {
     String filePath = "D:\\novel.txt";

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));

        bufferedWriter.write("拉钩");

        bufferedWriter.close();
    }
}
