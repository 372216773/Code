package com.wj.singleresponsibility;

import java.io.*;

//统计有多少个单词
public class singleResponsibility {

    public static String loadFile(String path) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            stringBuilder = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public static String[] getWords(String string) {
        //正则表达式
        return string.split("[^a-zA-Z]+");
    }

    public static void main(String[] args) {
        String file = loadFile("D:\\files\\create01.txt");

        String[] words = getWords(file);

        System.out.println(words.length);

    }
}
/*
单一性原则:每个类或每个方法每个框架只做一件事

优点:
1. 代码重用性提高
2. 代码可读性提高(大纲)
 */