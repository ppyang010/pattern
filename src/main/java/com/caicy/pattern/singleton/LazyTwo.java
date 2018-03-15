package com.caicy.pattern.singleton;

/**
 * 懒汉 方式2
 * 线程安全
 * 但性能擦
 */
public class LazyTwo {
    private static LazyTwo instance ;

    private LazyTwo(){

    }

    public static final synchronized LazyTwo getInstance(){
        if(null== instance){
            return new LazyTwo();
        }
        return instance;
    }
}
