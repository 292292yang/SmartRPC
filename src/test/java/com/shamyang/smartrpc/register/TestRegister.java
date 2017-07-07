package com.shamyang.smartrpc.register;

import com.shamyang.smartrpc.test.EchoImpl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by PC on 2017/7/5.
 */
public class TestRegister {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Register register=new Register();
        register.add("echo", EchoImpl.class);

        Class echo = register.get("echo");
        Object obj=echo.newInstance();
        try {
            Method[] methods = echo.getMethods();
            for(Method m:methods){
                System.out.println(m.getName()+"-----"+m.getParameterTypes());
            }
            Method say = echo.getDeclaredMethod("say",String.class);
            say.invoke(obj,"yangzhibin");
            System.out.println(echo.getDeclaredMethod("say",String.class).invoke(obj,"hh"));
//            System.out.println(echo.getDeclaredMethods()[0].invoke(obj,"yangzhibin"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
