package Lesson6.HomeWork;

import java.lang.reflect.*;

/**
 * Created by user on 01.08.16.
 */
public class MyInvocationHandler implements java.lang.reflect.InvocationHandler{
    private Object value;

    public MyInvocationHandler(Object value) {
        this.value = value;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("MyInvocationHandler invokes : " + method.getName());
        return method.invoke(value, args) ;
    }
}