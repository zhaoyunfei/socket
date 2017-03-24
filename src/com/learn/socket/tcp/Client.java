package com.learn.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by yunfei on 2017-03-24.
 */
public class Client {
    public static void main(String[] args) {
        //创建socket，指定服务器IP和port
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream os = socket.getOutputStream();
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：admin;密码：admin");
            pw.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine())!=null){
                System.out.println("客户端----服务器端说：" + info);
            }
            br.close();
            is.close();

            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
