package outputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件(原位置) --> 程序 --> 文件(指定位置)
public class FileCopy {
    public static void main(String[] args) {
        fileCopy();
    }

    public static void fileCopy() {
        String srcFilepath = "D:\\files\\books\\novel.txt";
        String deskFilepath = "D:\\novel.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] bytes = new byte[1024];
        int readLine = 0;
        try {
            fileInputStream = new FileInputStream(srcFilepath);
            fileOutputStream = new FileOutputStream(deskFilepath);
            while ((readLine = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, readLine);
            }
            System.out.println("拷贝完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally无论如何都会被执行,当new的时候出错的话,这个指针都是null,这时候在.close()就会出现空指针异常
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
