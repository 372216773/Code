package outputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//fileOutputStream将数据写入文件中,如果这个文件不存在,就会创建这个文件
public class fileOutputStream {
    public static void main(String[] args) {
        writeFile();
    }

    public static void writeFile() {
        String filepath = "D:\\files\\create01.txt";
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream1 = null;
        try {
            //1.new FileOutputStream(filepath),会覆盖原先内容
            fileOutputStream = new FileOutputStream(filepath);
            //1.写入一个字节
            fileOutputStream.write('w');
            //2.写入一个字符串
            String str = "gaogaofeiqilaiya";
            fileOutputStream.write(str.getBytes());
            //3.写入一个字符串的指定区域,[0,3)
            fileOutputStream.write(str.getBytes(),0,3);

            //2.new FileOutputStream(filepath,true),会在原有内容基础上追加内容
            fileOutputStream1 = new FileOutputStream(filepath,true);
            fileOutputStream1.write('f');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileOutputStream != null;
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
