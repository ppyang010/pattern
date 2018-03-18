package com.caicy.pattern.proxy;

import com.caicy.pattern.proxy.dynamic.CGLibDynamicProxy;
import com.caicy.pattern.proxy.dynamic.JDKDynamicProxy;
import com.caicy.pattern.proxy.staticed.HouseRentStaticProxy;

/**
 * Created by caicy on 2018/3/18.
 */
public class App {
    public static void main(String[] args) {
        //目的ccy要租一套房子
        //无代理模式
        //直接找房东A 要求租房子
        System.out.println("无代理");
        HouseOwnerA a = new HouseOwnerA();
        System.out.println("确定租期，房租，押金");
        a.rentOut("ccy");
        System.out.println("拿到钥匙");

        //静态代理
        //相对于不使用代理的模式来说 可以在不改变【被代理的类】 的情况下 通过【代理类】 做一些增强操作
        //如上面的租期之类的直接在代理类中完成
        System.out.println("静态代理");
        HouseRentStaticProxy houseRentStaticProxy = new HouseRentStaticProxy(new HouseOwnerA());
        houseRentStaticProxy.doRent("ccy");

        //动态代理
        //相对与静态代理来说 动态代理 不编写具体的代理类 而是通过编写 增强操作 然后动态的生成具体代理类
        System.out.println("动态代理");
        System.out.println("-----------jdk---------");
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(new HouseOwnerA());
        HouseRent houseRent = jdkDynamicProxy.getProxy();
        HouseClean houseClean = jdkDynamicProxy.getProxy();
        houseRent.rentOut("ccy");
//        houseClean.cleanHouse();

        System.out.println("----------cglib----------");
        HouseOwnerA proxy = new CGLibDynamicProxy().getProxy(HouseOwnerA.class);
        proxy.rentOut("ccy");
//        proxy.cleanHouse();


//        Proxy.newProxyInstance()



    }
}
