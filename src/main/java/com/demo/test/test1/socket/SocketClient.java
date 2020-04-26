package com.demo.test.test1.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
//            Socket socket = new Socket("127.0.0.1",8800);
            Socket socket = new Socket("10.1.21.31",12260);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String str = "hello,this is my first socket test!";
            bufferedWriter.write(str);
            // 刷新输入流
            bufferedWriter.flush();
            socket.shutdownOutput();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
