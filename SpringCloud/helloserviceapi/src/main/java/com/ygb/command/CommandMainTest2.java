package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 13:26
 */
public class CommandMainTest2 {

    public static void main(String[] args) {
        Barbecuer barbecuer = new Barbecuer();
        AbstractCommand chickenCommand = new BakeChickenCommand(barbecuer);
        AbstractCommand muttonCommand = new BakeMuttonCommand(barbecuer);

        Waiter waiter = new Waiter();
        waiter.setCommand(chickenCommand);
        waiter.action();

        waiter.setCommand(muttonCommand);
        waiter.action();


    }


}
