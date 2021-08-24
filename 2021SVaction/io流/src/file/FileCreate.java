package file;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) throws IOException {
        create01();
        create02();
        create03();
    }

    //new File(String pathname)
    public static void create01() {
        String pathname = "D:\\files\\create01.txt";
        //在内存中产生一个文件对象
        File file = new File(pathname);
        //把文件对象写入到磁盘中指定位置
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //new File(File parent, String child)
    public static void create02() {
        File file = new File("d:\\", "files\\create02.txt");
        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //new File(String parent, String child)
    public static void create03() {
        File file = new File("D:\\");
        File file1 = new File(file,"files\\create03.txt");
        try {
            file1.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
