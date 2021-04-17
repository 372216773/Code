package com.base;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
//发送端
public class Client {

    static Socket socket;
    static OutputStream outputStream;
    public static void main(String[] args) {
        try{
            //固定端口
            //本地进行通信  host:127.0.0.1
            socket = new Socket("127.0.0.1", 8080);
            System.out.println("连接成功");
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);

                outputStream.write(scanner.next().getBytes());
        }catch (IOException e) {
            System.out.println("连接服务器失败");          
        }finally {
            try {
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端关闭连接失败");
            }
        }
    }
}
