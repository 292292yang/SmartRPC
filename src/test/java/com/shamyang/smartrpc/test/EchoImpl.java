package com.shamyang.smartrpc.test;

/**
 * Created by PC on 2017/7/5.
 */
public class EchoImpl implements Echo{
    @Override
    public String say(String name) throws Exception {
        System.out.println("hello,"+name);
        if("yangzhibin".equals(name)){
            throw new Exception("eeeeee");
        }
        return "hello,"+name;
    }
}
