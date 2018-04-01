package com.caicy.pattern.observer.mouse;

/**
 * 具体观察类
 */
public class ClickListener implements IListener{
    /**
     * 被观察者状态更新后的回调方法
     *
     * @param event
     */
    @Override
    public void update(Event event) {
        System.out.println("鼠标单击事件回调方法触发");
    }
}
