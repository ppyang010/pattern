package com.caicy.pattern.proxy.myproxyiml;

import java.lang.reflect.Method;

public interface CaiInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
