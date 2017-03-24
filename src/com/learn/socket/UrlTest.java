package com.learn.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yunfei on 2017-03-23.
 */
public class UrlTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println("协议：" + url.getProtocol());
            System.out.println("主机：" + url.getHost());
            System.out.println("端口：" + url.getPort());
            System.out.println("路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("相对路径：" + url.getRef());
            System.out.println("查询字符串：" + url.getQuery());
            //字节输入流
            InputStream is = url.openStream();
            //字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            String data = br.readLine();
            while (data != null){
                System.out.println(data);
                data = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
