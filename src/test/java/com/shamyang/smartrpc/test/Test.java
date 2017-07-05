package com.shamyang.smartrpc.test;

import com.shamyang.smartrpc.proxy.RpcProxy;

/**
 * Created by PC on 2017/7/4.
 */
public class Test {

    public static void main(String[] args) {
        Echo echo = RpcProxy.getProxy(Echo.class, "127.0.0.1", 9011);
        echo.say("yangzhibin");
    }
}
