package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 12:17
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
