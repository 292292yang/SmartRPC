package com.shamyang.smartrpc.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shamyang on 2017/7/4.
 * RPC服务,用来处理客户端的请求
 */
public class RPCServer {

    public void init(int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream ois=new ObjectInputStream(inputStream);
                RpcRequest rpcRequest= (RpcRequest) ois.readObject();
                System.out.println(rpcRequest);
                RpcResponse rpcResponse=new RpcResponse();
                rpcResponse.setRequestId(rpcRequest.getRequestId());
                rpcResponse.setResult("hello");
                ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(rpcResponse);
                oos.flush();
                ois.close();
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        RPCServer server=new RPCServer();
        server.init(9011);
    }
}
