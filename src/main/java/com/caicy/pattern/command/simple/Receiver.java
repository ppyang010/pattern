package com.caicy.pattern.command.simple;

/**
 * 接受者
 * @author ccy
 */
public class Receiver {

    public void action(String msg){
        System.out.println("receiver action :" + msg);
    }
}
