package com.caicy.pattern.command.simple;

/**
 * @author ccy
 */
public class Client {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command commandA = new ConcreteCommandA(receiver);
        Command commandB = new ConcreteCommandB(receiver);
        Invoker invokerA = new Invoker(commandA);
        Invoker invokerB = new Invoker(commandB);
        invokerA.action();
        invokerB.action();
    }

}
