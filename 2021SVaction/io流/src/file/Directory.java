package file;

import java.io.File;

public class Directory {
    public static void main(String[] args) {
        ops2();
    }

    //在D:\files目录下删除create02.txt
    public static void ops1() {
        File file = new File("D:\\files\\create02.txt");

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除成功");
            }
        } else {
            System.out.println("没有该文件");
        }
    }

    //删除目录D:\files\file1
    public static void ops2() {
        File file = new File("D:\\files\\file1");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功");
            } else {
                System.out.println(file.getName() + "删除失败");
            }
        } else {
            System.out.println(file.getName() + "不存在");
        }
    }

    //创建目录D:\\files\\file1
    public static void ops3() {
        File file = new File("D:\\files\\file1");
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println(file.getName() + "创建成功");
            } else {
                System.out.println(file.getName() + "创建失败");
            }
        } else {
            System.out.println(file.getName() + "已存在");
        }
    }
}
