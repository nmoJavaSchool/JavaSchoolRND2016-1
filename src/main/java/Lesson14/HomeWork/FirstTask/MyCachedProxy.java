package Lesson14.HomeWork.FirstTask;


import Lesson6.HomeWork.MyRandom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by user on 28.08.16.
 */
public class MyCachedProxy {
    private ConcurrentHashMap<Arguments, Object> argumentsObjectConcurrentHashMap
            = new ConcurrentHashMap<Arguments, Object>();

    @SuppressWarnings("unchecked")
    public  <T> T create(final Class<T> cl, final T code) {

        return (T) Proxy.newProxyInstance(cl.getClassLoader(), new Class<?>[] { cl }, new InvocationHandler() {

            @Override
            public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
                final Arguments input = new Arguments(method, args);
                Object result = argumentsObjectConcurrentHashMap.get(input);

                if (result == null && !argumentsObjectConcurrentHashMap.containsKey(input)) {
                    try {
                        result = method.invoke( code, args);
                        argumentsObjectConcurrentHashMap.put(input, result);
                    } catch (InvocationTargetException e) {
                        throw e.getTargetException();
                    }
                }
                return result;
            }
        });
    }
}