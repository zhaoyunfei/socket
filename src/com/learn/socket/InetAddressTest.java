package com.learn.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by yunfei on 2017-03-23.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("计算机名：" + address.getHostName());
            System.out.println("IP地址：" + address.getHostAddress());
            byte[] bytes = address.getAddress();
            System.out.println("字节数组形式的IP" + Arrays.toString(bytes));
            System.out.println(address);

            InetAddress address1 = InetAddress.getByName("DESKTOP-JKJNQJH");
            InetAddress address2 = InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
