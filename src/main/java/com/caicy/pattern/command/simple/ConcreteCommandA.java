package com.caicy.pattern.command.simple;

/**
 * 具体命令
 * @author ccy
 */
public class ConcreteCommandA implements Command{
    private Receiver receiver;

    public ConcreteCommandA(Receiver receiver) {

        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action("commandA!!!" );
    }
}
