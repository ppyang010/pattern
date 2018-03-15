package com.caicy.pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册登记式
 *
 * 登记式单例：类似spring里面的方法，将类名注册，下次直接从里面获取
 *
 * 登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map(登记簿)中，对于已经登记过的实例，则从Map直接获取，对于没有登记的，则先登记，然后返回
 *
 * 内部实现还是用的饿汉式单例，因为其中的static方法块，它的单例在被装载的时候就被实例化了
 */
public class BeanFactory {

    private BeanFactory(){}

    //线程安全 用于保存类名和实例
    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    //装载自身 不是必须的
    static{
        BeanFactory me = new BeanFactory();
        ioc.put(me.getClass().getName(),me);
    }


    public synchronized Object getBean(String className){
        //这里有竞态条件
        if(!ioc.containsKey(className)){
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return obj;
        }else{
            return ioc.get(className);
        }

    }
}
