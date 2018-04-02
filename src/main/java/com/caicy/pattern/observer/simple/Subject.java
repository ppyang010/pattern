package com.caicy.pattern.observer.simple;

import java.util.Observable;

/**
 * 被观察者
 * Observable 为jdk提供的 被观察者基类
 */
public class Subject extends Observable {

    /**
     * 模拟发生更新
     * 通知所有的观察者
     */
    public void mockUpdate(){
        System.out.println("模拟发生更新");
        this.setChanged();
        this.notifyObservers();
    }

}
