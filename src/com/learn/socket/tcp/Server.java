package com.learn.socket.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yunfei on 2017-03-24.
 * 连接的，可靠的，有序的
 */
public class Server {
    public static void main(String[] args) {
        try {
            //创建服务器端socket，绑定端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket accept = null;
            int count = 0;
            System.out.println("服务器即将启动，等待客户端连接");
            //accept开始监听，等待客户端
            while (true){
                accept = serverSocket.accept();
                ServerThread serverThread = new ServerThread(accept);
                serverThread.start();
                count++;
                System.out.println("客户端的数量为：" + count);
                InetAddress address = accept.getInetAddress();
                System.out.println("当前客户端IP:" + address.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
