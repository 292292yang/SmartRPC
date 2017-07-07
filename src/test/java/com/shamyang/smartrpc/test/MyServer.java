package com.shamyang.smartrpc.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by PC on 2017/7/7.
 */
public class MyServer {

    public static void main(String[] args) {
        ServerSocket ss=null;
        try {
            ss=new ServerSocket(9811);
            while (true){
                Socket client = ss.accept();
                InputStream is = client.getInputStream();
                OutputStream os= client.getOutputStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line=br.readLine())!=null){
                    System.out.println("**********");
                    System.out.println(line);
                }

                System.out.println("11111111111111");
                BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
                System.out.println("2222222222");
                bw.write("fanfanfan");
                bw.newLine();
                bw.flush();
                client.shutdownOutput();
//                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
