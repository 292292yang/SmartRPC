package com.shamyang.smartrpc.common.bean;

import com.shamyang.smartrpc.common.bean.Methond;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by shamyang on 2017/7/4.
 * RPC请求封装
 */
public class RpcRequest implements Serializable {

    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 请求接口名
     */
    private String interfaces;

    private Methond methond;

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

    public String getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(String interfaces) {
        this.interfaces = interfaces;
    }

    public Methond getMethond() {
        return methond;
    }

    public void setMethond(Methond methond) {
        this.methond = methond;
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
                ", methond=" + methond +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
