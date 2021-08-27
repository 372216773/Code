package com.wj.designPrinciple.singleresponsibility;

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

    //找到两个文件中相同单词
    public static void findSameWords(String path1, String path2) {
        String file = loadFile(path1);
        String file1 = loadFile(path2);

        String[] words = getWords(file);
        String[] words1 = getWords(file1);

        String[] sameElements = getSameElement(words, words1);
        for (String str : sameElements) {
            System.out.println(str);
        }
    }

    public static String[] getSameElement(String[] words, String[] words1) {

        //List<String> list = Arrays.asList(words);此时得到的list是不能那个修改值的
        List<String> list = new ArrayList<>(Arrays.asList(words));
        List<String> list1 = new ArrayList<>(Arrays.asList(words1));
        /*for (String word : words) {
            for (String s : words1) {
                if (word.equals(s)) {
                    hashSet.add(word);
                }
            }
        }*/
        //计算交集,结果存放到list中,list2不变
        list.retainAll(list1);
        HashSet<String> hashSet = new HashSet<>(list);
        //集合变成数组时,转成参数的类型
        return hashSet.toArray(new String[0]);
    }

    public static void main(String[] args) {

        //加载文件
        String file = loadFile("D:\\files\\create01.txt");
        String file1 = loadFile("D:\\files\\create02.txt");

        //得到单词
        String[] words = getWords(file);
        String[] words1 = getWords(file1);

        //1.找出相同单词
        String[] sameElement = getSameElement(words, words1);

        //2.找出相同单词
        findSameWords(file, file1);

    }
}
/*
单一性原则:每个类或每个方法每个框架只做一件事

优点:
1. 代码重用性提高
2. 代码可读性提高(大纲)
 */