package com.shamyang.smartrpc.server;

import com.shamyang.smartrpc.register.Register;
import com.shamyang.smartrpc.test.EchoImpl;

/**
 * Created by PC on 2017/7/7.
 */
public class TestRpcServer {

    public static void main(String[] args) {
        Register register=new Register();
        register.add("echo", EchoImpl.class);
        RPCServer rpcServer=new RPCServer(register);
        rpcServer.init(9011);
    }
}
