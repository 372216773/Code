package writer;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {
    public static void main(String[] args) {
        fw();
    }

    public static void fw() {
        String filePath = "D:\\novel.txt";
        FileWriter fileWriter = null;
        char[] buffer = {'a', 'b', 'c'};
        String string = "彩虹海";

        try {
            fileWriter = new FileWriter(filePath, true);

            //1. write(int):写入单个字符
            fileWriter.write('c');

            //2. write(char[]):写入指定数组
            fileWriter.write(buffer);

            //3. write(char[],off,len):写入指定数组的指定部分
            fileWriter.write(buffer, 0, 2);

            //4. write(string):写入整个字符串
            fileWriter.write(string);

            //5. write(string,off,len):写入整个字符串的指定部分
            fileWriter.write(string, 0, 1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    //close=flush+关闭
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
