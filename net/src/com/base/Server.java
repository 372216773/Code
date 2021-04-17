package com.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//接收端
public class Server {

    private static InputStream inputStream;
    private static Socket accept;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("正在等待客户端连接......");
            while(true) {
                //accept:等待客户端连接
                // 这是一个阻塞方法:一直会停在这,直到客户端进来,才会向下执行
                // 返回一个代表客户端的抽象对象
                accept = serverSocket.accept();
                System.out.println("有人来了"+ accept.getInetAddress().getHostAddress());
                inputStream = accept.getInputStream();

                byte[] buffer = new byte[1024];
                int len = 0;
                //read()会一直等待接收,也是阻塞
                while((len = inputStream.read(buffer)) != -1) {
                    System.out.println(new String(buffer,0,len));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("正在释放资源......");
                inputStream.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("释放资源异常");
            }
        }

    }
}
