package file;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {
        information();
    }

    public static void information() {
        //创建文件对象
        File file = new File("D:\\files\\create01.txt");

        System.out.println("fileName = " + file.getName());
        System.out.println("filePath = " + file.getPath());
        System.out.println("absoluteFile = " + file.getAbsoluteFile());
        System.out.println("absolutePath = " + file.getAbsolutePath());
        System.out.println("parent = " + file.getParent());
        System.out.println("parentFile = " + file.getParentFile());
        System.out.println("directory = " + file.isDirectory());
        System.out.println("file1 = " + file.isFile());
        System.out.println("length = " + file.length());
    }
}
