package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 12:18
 */
public class MainClient {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();


    }


}
