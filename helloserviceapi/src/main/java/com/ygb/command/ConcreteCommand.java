package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 12:16
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
