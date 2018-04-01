package com.caicy.pattern.observer;

import com.caicy.pattern.observer.mouse.ClickListener;
import com.caicy.pattern.observer.mouse.Mouse;
import com.caicy.pattern.observer.mouse.MouseEventType;

public class App {
    public static void main(String[] args) {
        ClickListener clickListener = new ClickListener();
        Mouse mouse = new Mouse();
        //注册事件 可以用扫描的方式注册
        mouse.attach(MouseEventType.ON_CLICK,clickListener);
        mouse.click();
    }
}
