package com.caicy.pattern.observer.mouse;

import java.lang.reflect.Method;

/**
 * 事件对象
 * 被观察者状态发生变化后的一些状态信息的封装对象
 * 一般用于传递给观察者
 */
public class Event {

    //事件源 被观察者
    private Object source;
    //通知目标 观察者
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    private long time;

    public Event(Object source, Object target) {
        this.source = source;
        this.target = target;
    }


    public Object getSource() {
        return source;
    }


    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source + ",\n" +
                "\ttarget=" + target + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + '\'' + "\n" +
                '}';
    }

    public long getTime() {
        return time;
    }

    Event setTime(long time) {
        this.time = time;
        return this;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}
