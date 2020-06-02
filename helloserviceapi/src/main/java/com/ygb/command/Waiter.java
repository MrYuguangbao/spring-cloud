package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 13:16
 */
public class Waiter {

    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }

}
