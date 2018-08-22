package com.caicy.pattern.command.simple;

/**
 * 请求者
 *
 * @author ccy
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
