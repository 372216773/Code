package com.wj.singleresponsibility;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//统计有多少个单词
public class singleResponsibility {

    //记载文件
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

    //获得单词
    public static String[] getWords(String string) {
        //正则表达式[^a-zA-Z]非字母当作分隔符;[^a-zA-Z]+连续的非字母当分隔符
        return string.split("[^a-zA-Z]+");
    }

    public static void main(String[] args) {

        //加载文件
        String file = loadFile("D:\\files\\create01.txt");
        String file1 = loadFile("D:\\files\\create01.txt");

        //得到单词
        String[] words = getWords(file);
        String[] words1 = getWords(file1);

        //1.找出相同单词
        String[] sameElement = getSameElement(words, words1);

        //2.找出相同单词
        findSameWords(file,file1);

    }
}
/*
单一性原则:每个类或每个方法每个框架只做一件事

优点:
1. 代码重用性提高
2. 代码可读性提高(大纲)
 */