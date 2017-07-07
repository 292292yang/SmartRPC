package com.shamyang.smartrpc.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by shamyang on 2017/7/6.
 * 标识客户端调用的服务端提供的接口名
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcAnnotation {

    /**
     * 服务名称
     *
     * @return
     */
    String serviceName() default "";
}
