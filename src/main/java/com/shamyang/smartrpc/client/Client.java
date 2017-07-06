package com.shamyang.smartrpc.client;

import com.shamyang.smartrpc.server.RpcRequest;
import com.shamyang.smartrpc.server.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by shamyang on 2017/7/4.
 */
public class Client {

    private String host;

    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public RpcResponse invoke(RpcRequest rpcRequest){
        try {
            Socket socket=new Socket(host,port);
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(rpcRequest);
            oos.flush();
            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            RpcResponse rpcResponse= (RpcResponse) ois.readObject();
            return rpcResponse;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
