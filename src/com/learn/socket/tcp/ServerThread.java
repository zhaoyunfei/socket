package com.learn.socket.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by yunfei on 2017-03-24.
 */
public class ServerThread extends Thread {
    Socket accept = null;

    public ServerThread(Socket socket) {
        this.accept = socket;
    }

    @Override
    public void run() {
        //获取输入流
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            is = accept.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println("服务器----客户端说：" + data);
            }
            accept.shutdownInput();//关闭输入流

            os = accept.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (os != null) {
                    os.close();
                }
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (is != null) {
                    is.close();
                }
                if (accept != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
