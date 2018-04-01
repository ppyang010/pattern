package com.caicy.pattern.observer.mouse;

/**
 * 抽象观察者
 * 为具体观察者定义可以监听的方式
 */
public interface IListener {
    /**
     * 被观察者状态更新后的回调方法
     */
    void update(Event event);

}
