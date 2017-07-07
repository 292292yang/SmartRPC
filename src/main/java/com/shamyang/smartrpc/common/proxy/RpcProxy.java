package com.shamyang.smartrpc.common.proxy;

import com.shamyang.smartrpc.client.Client;
import com.shamyang.smartrpc.common.annotation.RpcAnnotation;
import com.shamyang.smartrpc.common.bean.Methond;
import com.shamyang.smartrpc.common.bean.RpcRequest;
import com.shamyang.smartrpc.common.bean.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.UUID;

/**
 * Created by PC on 2017/7/4.
 */
public class RpcProxy {

    public static <T> T getProxy(Class<T> clazz, String host, int port) {

        Client client = new Client(host, port);
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.setRequestId(UUID.randomUUID().toString());
            rpcRequest.setMethond(new Methond(method.getName(), method.getParameterTypes()));
            RpcAnnotation annotation = clazz.getAnnotation(RpcAnnotation.class);
            rpcRequest.setInterfaces(annotation.serviceName());
            rpcRequest.setParameters(args);
            RpcResponse response = client.invoke(rpcRequest);
            if(response.getException()!=null){
                throw response.getException();
            }
            return response.getResult();
        };
        return (T) Proxy.newProxyInstance(RpcProxy.class.getClassLoader(), new Class[]{clazz}, invocationHandler);
    }
}
