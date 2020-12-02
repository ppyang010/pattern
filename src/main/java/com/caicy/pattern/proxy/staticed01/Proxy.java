package com.caicy.pattern.proxy.staticed01;

public class Proxy implements Subject{
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("Proxy request()");
        subject.request();
    }
}
