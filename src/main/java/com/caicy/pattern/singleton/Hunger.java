package com.caicy.pattern.singleton;

/**
 * 饿汉
 * 绝对线程安全
 * 但是会有资源浪费 因为只要类加载就会创建实例 而类加载不一定是获取实例的时候
 */
public class Hunger {

    private static Hunger instance = new Hunger();

    private Hunger(){

    }
    public static final Hunger getInstance(){
        return instance;
    }

}
