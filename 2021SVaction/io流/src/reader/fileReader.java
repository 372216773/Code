package reader;

import java.io.FileReader;
import java.io.IOException;

//
public class fileReader {
    public static void main(String[] args) {
        fr1();
    }

    public static void fr() {
        String filePath = "D:\\novel.txt";
        FileReader fileReader = null;
        int read = 0;
        try {
            fileReader = new FileReader(filePath);
            while ((read = fileReader.read()) != -1) {
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fr1() {
        String filePath = "D:\\novel.txt";
        FileReader fileReader = null;
        int read = 0;
        char[] buffer = new char[8];
        try {
            fileReader = new FileReader(filePath);
            while ((read = fileReader.read(buffer)) != -1) {
                System.out.print(new String(buffer,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
