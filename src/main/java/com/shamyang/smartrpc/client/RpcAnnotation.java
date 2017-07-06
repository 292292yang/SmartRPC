package com.shamyang.smartrpc.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by shamyang on 2017/7/6.
 */
@Target(ElementType.METHOD)
public @interface RpcAnnotation {

    /**
     * 服务名称
     *
     * @return
     */
    String serviceName() default "";
}
