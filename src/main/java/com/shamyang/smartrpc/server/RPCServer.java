package com.shamyang.smartrpc.server;

import com.shamyang.smartrpc.common.bean.RpcRequest;
import com.shamyang.smartrpc.common.bean.RpcResponse;
import com.shamyang.smartrpc.register.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shamyang on 2017/7/4.
 * RPC服务,用来处理客户端{@link com.shamyang.smartrpc.client.Client}的请求{@link RpcRequest},
 * 处理完成之后返回{@link RpcResponse}
 */
public class RPCServer {

    private static final Logger logger = LoggerFactory.getLogger(RPCServer.class);

    private Register register;

    public RPCServer(Register register) {
        this.register = register;
    }

    public void init(int port) {
        ServerSocket serverSocket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            logger.error("RPCServer启动服务失败,失败原因:", e);
        }
        while (true) {
            Socket socket = null;
            RpcResponse rpcResponse = new RpcResponse();
            try {
                socket = serverSocket.accept();
                ois = new ObjectInputStream(socket.getInputStream());
                oos = new ObjectOutputStream(socket.getOutputStream());
                RpcRequest rpcRequest = (RpcRequest) ois.readObject();
                logger.debug("RPCServer接收到的request={}", rpcRequest);
                Class interfaces = register.get(rpcRequest.getInterfaces());
                Object obj = interfaces.newInstance();
                rpcResponse.setRequestId(rpcRequest.getRequestId());
                Method methond = interfaces.getDeclaredMethod(rpcRequest.getMethond().getName(), rpcRequest.getMethond().getParameterTypes());
                Object result = methond.invoke(obj, rpcRequest.getParameters());
                rpcResponse.setResult(result);
                logger.debug("RPCServer返回值,response={}", rpcResponse);
            } catch (IOException
                    | ClassNotFoundException
                    | IllegalAccessException
                    | InstantiationException
                    | NoSuchMethodException
                    | InvocationTargetException e) {
                rpcResponse.setException(e);
                logger.error("RPCServer处理请求出错,错误信息:", e);
            } finally {
                try {
                    oos.writeObject(rpcResponse);
                    oos.flush();
                    if (ois != null) {
                        ois.close();
                    }
                    if (oos != null) {
                        oos.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    logger.error("RPCServer处理请求出错,错误信息:", e);
                } catch (Exception e) {
                    logger.error("RPCServer处理请求出错,错误信息:", e);
                }
            }
        }
    }
}
