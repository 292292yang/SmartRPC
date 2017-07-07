package com.shamyang.smartrpc.test;

import com.shamyang.smartrpc.common.proxy.RpcProxy;

/**
 * Created by PC on 2017/7/4.
 */
public class Test {

    public static void main(String[] args) {
        Echo echo = RpcProxy.getProxy(Echo.class, "127.0.0.1", 9011);
        String result = null;
        try {
            result = echo.say("yangzhibin2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result="+result);
    }
}
