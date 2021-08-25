package writer;

import java.io.*;
/*
不要去操作二进制文件,会损坏,因为这是按照字符读取的
 */
public class bufferedCopy {
    public static void main(String[] args) throws IOException {

    }

    public static void byteCopy() throws IOException {
        String srcFilepath = "D:\\files\\books\\novel.txt";
        String destFilePath = "D:\\files\\novel.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilepath));
            bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
            String data;
            while((data=bufferedReader.readLine())!=null) {
                bufferedWriter.write(data);
                //插入换行
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
