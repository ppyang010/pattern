package com.caicy.pattern.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/18.
 */
public class CGLibDynamicProxy implements MethodInterceptor{


    public <T> T getProxy(Class<T> cls){
        //创建代理类
        //参数1 被代理类 的class
        //参数2 MethodInterceptor 的实现类
        return (T) Enhancer.create(cls,this);
    }

    /**
     *
     * @param obj 生成的代理类
     * @param method 调用的真实对象方法
     * @param args 调用的真实对象方法的参数
     * @param methodProxy 
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("rentOut")){
            beforeRent();
        }
        System.out.println(obj.getClass().toString());
        System.out.println(methodProxy.getClass().toString());
        Object res = methodProxy.invokeSuper(obj,args);
        if(method.getName().equals("rentOut")){
            afterRent();
        }
        return res;
    }
    //这里的before after 方法可以提取出去
    public void beforeRent(){
        System.out.println("确定租期，房租，押金");
    }

    public void afterRent(){
        System.out.println("拿到钥匙");
    }
}
