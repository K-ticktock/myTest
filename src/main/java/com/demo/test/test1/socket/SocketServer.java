package com.demo.test.test1.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        try {
            // 初始化服务端socket并绑定8800端口
            ServerSocket serverSocket = new ServerSocket(8800);
            // 等待客户端连接
            Socket socket = serverSocket.accept();
            // 获取输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 读取一行数据
            String str = bufferedReader.readLine();
            // 输出打印
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
