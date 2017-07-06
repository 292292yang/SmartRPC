package com.shamyang.smartrpc.test;

/**
 * Created by PC on 2017/7/5.
 */
public class EchoImpl implements Echo{
    @Override
    public void say(String name) {
        System.out.println("hello,"+name);
    }
}
