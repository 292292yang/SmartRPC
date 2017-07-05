package com.shamyang.smartrpc.server;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by shamyang on 2017/7/4.
 * RPC请求封装
 */
public class RpcRequest implements Serializable{

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 请求接口名
     */
    private Class interfaces;

    /**
     * 请求方法名
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 参数
     */
    private Object[] parameters;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Class getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class interfaces) {
        this.interfaces = interfaces;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "requestId='" + requestId + '\'' +
                ", interfaces='" + interfaces + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
