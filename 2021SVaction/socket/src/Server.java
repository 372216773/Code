import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static InputStream inputStream;
    private static ServerSocket serverSocket;
    public static void main(String[] args) {
        try {
            /*
             *创建ServerSocket
             *  内部进行了端口绑定
             */
            serverSocket = new ServerSocket(8089);
            System.out.println("正在等待客户端连接....");

            while (true) {
                //accept: 等待客户端连接   这是一个阻塞方法,返回一个代表客户端的"抽象对象"
                //只有客户端链接进来,才向下执行
                Socket socket = serverSocket.accept();
                System.out.println("有客户端连接进来了:" + socket.getInetAddress().getHostAddress());
                //获取到输入流
                inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1) {
                    System.out.println(new String(buffer, 0, len));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //服务器没必要主动释放资源
            try {
                System.out.println("资源正在释放中...");
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("释放资源异常");
            }
        }
    }
}
