package com.caicy.pattern.proxy.staticed01;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("RealSubject request()");
    }
}
