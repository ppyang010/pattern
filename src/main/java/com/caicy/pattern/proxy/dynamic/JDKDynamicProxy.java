package com.caicy.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by Administrator on 2018/3/18.
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target){
        this.target=target;
    }

    /**
     *
     * @param proxy 指代生成的代理对象
     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args 指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("rentOut")){
            beforeRent();
        }
        System.out.println(proxy.getClass().toString());
        method.invoke(this.target,args);
        if(method.getName().equals("rentOut")){
            afterRent();
        }
        return null;
    }
    public <T> T getProxy(){
//        loader:　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
//        interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理类对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
//        h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
        T proxyInstance = (T) Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
        System.out.println(proxyInstance.getClass().toString());
        System.out.println("getProxy");
        return proxyInstance;
    }
    //这里的before after 方法可以提取出去
    public void beforeRent(){
        System.out.println("确定租期，房租，押金");
    }

    public void afterRent(){
        System.out.println("拿到钥匙");
    }

}
