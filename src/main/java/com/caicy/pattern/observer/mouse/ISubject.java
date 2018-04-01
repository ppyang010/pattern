package com.caicy.pattern.observer.mouse;

import java.util.Observer;

/**
 * 抽象被观察者
 * 提供对持有的观察者对象集合的一些操作
 */
public interface ISubject {

    /**
     * 注册观察者对象
     *
     * @param listener 观察者对象
     */
    void attach(MouseEventType eventType,IListener listener);

    /**
     * 删除观察者对象
     *
     * @param listener 观察者对象
     */
    void detach(MouseEventType eventType,IListener listener);

    /**
     * 触发事件
     * @param eventType
     */
    void trigger(MouseEventType eventType);


}

