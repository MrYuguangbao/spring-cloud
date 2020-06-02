package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 13:04
 */
public abstract class AbstractCommand {

    protected Barbecuer barbecuer;

    public AbstractCommand(Barbecuer barbecuer) {
        this.barbecuer = barbecuer;
    }

    abstract void execute();


}
