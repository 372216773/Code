package file;

import java.io.File;

public class Directory {
    public static void main(String[] args) {
        directory();
    }

    public static void directory() {
        File file = new File("D:\\files\\create02.txt");

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除成功");
            }
        }else{
            System.out.println("没有该文件");
        }
    }
}
