package com.shamyang.smartrpc.proxy;

import com.shamyang.smartrpc.client.Client;
import com.shamyang.smartrpc.client.RpcAnnotation;
import com.shamyang.smartrpc.server.RpcRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * Created by PC on 2017/7/4.
 */
public class RpcProxy{

    public static  <T> T getProxy(Class<T> clazz, String host, int port) {

        Client client=new Client(host,port);
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.setRequestId(UUID.randomUUID().toString());
            rpcRequest.setMethodName(method.getName());
            RpcAnnotation annotation = method.getAnnotation(RpcAnnotation.class);
            String s = annotation.serviceName();
            System.out.println("--------s-------"+s);
            rpcRequest.setInterfaces(clazz.getClass());
            return client.invoke(rpcRequest);
        };
        return (T) Proxy.newProxyInstance(RpcProxy.class.getClassLoader(), new Class[]{clazz}, invocationHandler);
    }
}
