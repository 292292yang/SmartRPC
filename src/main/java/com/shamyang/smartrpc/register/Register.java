package com.shamyang.smartrpc.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shamyang on 2017/7/4.
 * 注册中心
 */
public class Register {

    private final Map<String, Class> map = new ConcurrentHashMap<>();

    public  void add(String key, Class clazz) {
        map.put(key, clazz);
    }

    public  Class get(String key){
        return map.get(key);
    }
}
