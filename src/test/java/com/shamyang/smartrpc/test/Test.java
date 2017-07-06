package com.shamyang.smartrpc.test;

import com.shamyang.smartrpc.proxy.RpcProxy;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by PC on 2017/7/4.
 */
public class Test {


    private static class T1 extends ThreadLocal<Integer> implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"------>>>"+this.get());
        }

        @Override
        protected Integer initialValue(){
//            System.out.println(Thread.currentThread().getName());
            return new Random().nextInt();
        }
    }

    public static void main(String[] args) {
//        Echo echo = RpcProxy.getProxy(Echo.class, "127.0.0.1", 9011);
//        echo.say("yangzhibin");
        T1 t1=new T1();
        T1 t2=new T1();
        T1 t3=new T1();
        T1 t4=new T1();
        ExecutorService es= Executors.newFixedThreadPool(1);
        es.submit(t1);
        es.submit(t1);
        es.submit(t1);
        es.submit(t1);
        es.shutdown();
    }
}
