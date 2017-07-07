package com.shamyang.smartrpc.test;

import com.shamyang.smartrpc.common.annotation.RpcAnnotation;

/**
 * Created by shamyang on 2017/7/4.
 */
@RpcAnnotation(serviceName = "echo")
public interface Echo {

    String say(String name) throws Exception;
}
