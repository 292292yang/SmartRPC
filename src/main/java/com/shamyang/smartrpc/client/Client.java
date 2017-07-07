package com.shamyang.smartrpc.client;

import com.shamyang.smartrpc.common.bean.RpcRequest;
import com.shamyang.smartrpc.common.bean.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by shamyang on 2017/7/4.
 * RPC调用客户端,通过TCP连接server,将{@link RpcRequest}传输到{@link com.shamyang.smartrpc.server.RPCServer}
 */
public class Client {

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    private String host;

    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public RpcResponse invoke(RpcRequest rpcRequest) {
        try {
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(rpcRequest);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            RpcResponse rpcResponse = (RpcResponse) ois.readObject();
            return rpcResponse;
        } catch (IOException | ClassNotFoundException e) {
            logger.error("rpc client调用失败,失败原因:", e);
        } catch (Exception e) {
            logger.error("rpc client调用失败,失败原因:", e);
        }
        return null;
    }
}
