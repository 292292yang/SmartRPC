package com.shamyang.smartrpc.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shamyang on 2017/7/4.
 * 注册中心
 */
public class Register {

    private static final Map<String, Object> map = new ConcurrentHashMap<>();

    public static void add(String key, Object value) {
        map.put(key, value);
    }

}
