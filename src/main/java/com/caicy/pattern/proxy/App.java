package com.caicy.pattern.proxy;

import com.caicy.pattern.proxy.dynamic.CGLibDynamicProxy;
import com.caicy.pattern.proxy.dynamic.JDKDynamicProxy;
import com.caicy.pattern.proxy.staticed.HouseRentStaticProxy;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

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

        //动态代理原理
        //原理：
        //1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
        //2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
        //3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
        //4、编译新生成的Java代码.class
        //5、再重新加载到JVM中运行
        //以上这个过程就叫做字节码重组

        //JDK中有个规范，只要要是$开头的一般都是自动生成的

        //通过反编译工具可以查看源代码
        try {
            byte [] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{HouseRent.class});
            FileOutputStream os = new FileOutputStream("/Users/ccy/$Proxy0.class");
            os.write(bytes);
            os.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
