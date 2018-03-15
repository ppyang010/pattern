package com.caicy.pattern.singleton;

/**
 * 懒汉 方式1
 * 不是线程安全的
 */
public class LazyOne {
    private static LazyOne instance ;

    private LazyOne(){

    }

    public static final LazyOne getInstance(){
        //这里存在竞态条件 不是线程安全 多线程可能会创建出多个实例
        if(null== instance){
            return new LazyOne();
        }
        return instance;
    }
}
