import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        String file1 = FileLoad("D:\\files\\file1.txt");
        String file2 = FileLoad("D:\\files\\file2.txt");

        List<String> list = ChangeToList(file1);
        List<String> list1 = ChangeToList(file2);

        String[] someWords = getSomeWords(list, list1);
        System.out.println(Arrays.toString(someWords));
        String[] array = ChangeToArray(file1);
        boolean aTrue = isTrue(someWords, array);
        System.out.println(aTrue);


    }

    /**
     * @param FilePath 路径
     * @return 返回所有句子
     */
    public static String FileLoad(String FilePath) {
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = null;
        String buffer = null;
        try {
            //读文件
            bufferedReader = new BufferedReader(new FileReader(FilePath));
            stringBuffer = new StringBuffer();
            int line;
            while ((buffer = bufferedReader.readLine()) != null) {
                stringBuffer.append(buffer);
                stringBuffer.append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /*
    将字符串转换为list
     */
    public static List<String> ChangeToList(String file) {
        String[] strings1 = file.split(" ");
        return new ArrayList<String>(Arrays.asList(strings1));
    }

    /**
     * 变为数组
     * @param file
     * @return
     */
    public static String[] ChangeToArray(String file) {
        return file.split("[^a-zA-Z]+");
    }

    /**
     * 查找相同单词
     *
     * @return 返回相同
     */
    public static String[] getSomeWords(List<String> list1, List<String> list2) {
        HashSet<Object> hashSet = new HashSet<>();
        for (String str : list1) {
            if (list2.contains(str)) {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[0]);
    }

    public static boolean isTrue(String[] someWords, String[] files) {
        return someWords.length * 0.1 / files.length < 0.3;
    }
}
