package com.shamyang.smartrpc.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shamyang on 2017/7/4.
 * RPC服务,用来处理客户端的请求
 */
public class RPCServer {

    private static final Logger logger= LoggerFactory.getLogger(RPCServer.class);

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

                Class interfaces = rpcRequest.getInterfaces();
                Object obj=interfaces.newInstance();
                Method declaredMethod = interfaces.getDeclaredMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
                Object result = declaredMethod.invoke(obj, rpcRequest.getParameters());
                RpcResponse rpcResponse=new RpcResponse();
                rpcResponse.setRequestId(rpcRequest.getRequestId());
                rpcResponse.setResult(result);
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
}
