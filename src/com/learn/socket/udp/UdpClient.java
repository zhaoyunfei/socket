package com.learn.socket.udp;

import java.io.IOException;
import java.net.*;

/**
 * Created by yunfei on 2017-03-24.
 */
public class UdpClient {
    public static void main(String[] args) {
        //定义服务器地址、端口号，数据
        try {
            InetAddress address = InetAddress.getByName("localhost");
            int port = 8800;
            byte[] data = "用户名：admin;密码：admin".getBytes();
            //创建数据报
            DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            byte[] data1 = new byte[1024];
            DatagramPacket packet1 = new DatagramPacket(data1,data1.length);
            socket.receive(packet1);
            String data2 = new String(data1,0,packet1.getLength());
            System.out.println("客户端----服务器端说：" + data2);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
