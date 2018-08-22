package com.caicy.pattern.command.simple;

/**
 * 具体命令
 * @author ccy
 */
public class ConcreteCommandB implements Command{

    private Receiver receiver;

    public ConcreteCommandB(Receiver receiver) {

        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action("commandB!!!" );

    }
}
