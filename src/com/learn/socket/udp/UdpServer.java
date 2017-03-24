package com.learn.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by yunfei on 2017-03-24.
 */
public class UdpServer {
    public static void main(String[] args) {
        try {
            //创建DatagramSocket,指定端口
            DatagramSocket socket = new DatagramSocket(8800);
            //创建数据报
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            //接收
            socket.receive(packet);//接受数据报前处于阻塞状态
            //读取数据
            String info = new String(data,0,packet.getLength());
            System.out.println("服务器----客户端说：" + info);

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] bytes = "欢迎您".getBytes();
            DatagramPacket packet1 = new DatagramPacket(bytes,bytes.length,address,port);
            socket.send(packet1);
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
