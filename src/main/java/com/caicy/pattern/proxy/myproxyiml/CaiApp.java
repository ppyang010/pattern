package com.caicy.pattern.proxy.myproxyiml;

import com.caicy.pattern.proxy.HouseOwnerA;
import com.caicy.pattern.proxy.HouseRent;

import java.lang.reflect.Proxy;

public class CaiApp {
    public static void main(String[] args) {
        CaiDynamicProxy proxy = new CaiDynamicProxy(new HouseOwnerA());
        HouseRent house = proxy.getProxy();
        house.rentOut("caicy");
    }
}
