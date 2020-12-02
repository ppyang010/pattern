package com.caicy.pattern.proxy.dynamic01;

import com.caicy.pattern.proxy.staticed01.RealSubject;
import com.caicy.pattern.proxy.staticed01.Subject;

public class Client {
    public static void main(String[] args) {
//        JDKProxy jdkProxy = new JDKProxy(new RealSubject());
//        Subject proxy = jdkProxy.getProxy();
//        proxy.request();

        CGLibProxy cgLibProxy = new CGLibProxy();
        Subject proxy = cgLibProxy.getProxy(new RealSubject().getClass());
        proxy.request();
    }
}
