package com.caicy.pattern.proxy.dynamic01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDKProxy invoke");
        return method.invoke(this.target, args);
    }

    public <T> T getProxy() {
        T proxyInstance = (T) Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this);
        return proxyInstance;
    }
}
