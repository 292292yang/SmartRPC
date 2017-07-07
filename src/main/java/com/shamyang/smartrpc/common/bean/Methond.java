package com.shamyang.smartrpc.common.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by shamyang on 2017/7/7.
 * 通过{@link RpcRequest},传输到{@link com.shamyang.smartrpc.server.RPCServer}
 */
public class Methond implements Serializable{

    /**
     * 方法名
     */
    private String name;

    /**
     * 方法参数类型
     */
    private Class<?>[] parameterTypes;

    public Methond(String name, Class<?>[] parameterTypes) {
        this.name = name;
        this.parameterTypes = parameterTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    @Override
    public String toString() {
        return "Methond{" +
                "name='" + name + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
