import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.15", 8089);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello Socket1".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}