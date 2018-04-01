package com.caicy.pattern.observer.mouse;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体的被观察者角色
 */
public class Mouse implements ISubject{

    /**
     * 相当于观察者集合 只是这里都封装到事件对象中去了
     */
//    protected Map<Enum,Event> listeners = new HashMap<Enum,Event>();

    protected Map<Enum,IListener> listeners = new HashMap<Enum,IListener>();

    /**
     * 注册观察者对象
     *
     * @param listener 观察者对象
     */
    @Override
    public void attach(MouseEventType eventType,IListener listener) {
        listeners.put(eventType,listener);
    }

    /**
     * 删除观察者对象
     *
     * @param listener 观察者对象
     */
    @Override
    public void detach(MouseEventType eventType,IListener listener) {

    }

    /**
     * 触发事件
     *
     * @param eventType
     */
    @Override
    public void trigger(MouseEventType eventType) {
        this.listeners.get(eventType).update(null);
    }

    public void click(){
        System.out.println("鼠标单击");
        //通知被观察者 触发回调

        this.trigger(MouseEventType.ON_CLICK);
    }
}
