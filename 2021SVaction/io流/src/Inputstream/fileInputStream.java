package Inputstream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//字节输入流(如果是两个字节的中文字符,就会中文字符拆分来解析,就会乱码) 文件-->程序
public class fileInputStream {
    public static void main(String[] args) {
        readFile1();
    }

    /*
    read()单字节读取,效率低
     */
    public static void readFile() {
        String pathname = "D:\\files\\create01.txt";
        FileInputStream fileInputStream = null;
        int readData=0;
        try {
             fileInputStream= new FileInputStream(pathname);
            //读出-1,表明读取完毕
            while ((readData=fileInputStream.read())!=-1) {
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    使用read(byte[])读取
     */
    public static void readFile1() {
        String pathname = "D:\\files\\create01.txt";
        FileInputStream fileInputStream=null;
        byte[] buf = new byte[6];
        int readLine=0;
        try {
             fileInputStream= new FileInputStream(pathname);
             //返回读取的字节数
            while((readLine = fileInputStream.read(buf))!=-1) {
                System.out.print(new String(buf,0,readLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
