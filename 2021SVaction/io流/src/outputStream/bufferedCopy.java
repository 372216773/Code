package outputStream;

import java.io.*;

//二进制文件的字节操作
public class bufferedCopy {
    public static void main(String[] args) {
        String srcFilePath = "D:\\wj\\Pictures\\sansi.jpg";
        String destFilePath = "D:\\sansi.jpg";
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        //
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //1KB
            byte[] bytes = new byte[1024];
            int readLine = 0;

            while ((readLine = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes,0,readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedInputStream != null;
                assert bufferedOutputStream != null;
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
