package com.shamyang.smartrpc.test;

import java.io.*;
import java.net.Socket;

/**
 * Created by PC on 2017/7/7.
 */
public class MyClient {

    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1",9811);
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
            bw.write("111111");
            bw.newLine();
            bw.flush();
            socket.shutdownOutput();
            InputStream is=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line;
            System.out.println("-----------client 准备读取------");
            while ((line=br.readLine())!=null){
                System.out.println("-----------client 2222------");
                System.out.println("返回值:"+line);
            }
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
