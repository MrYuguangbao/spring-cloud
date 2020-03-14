package com.ygb.command;

/**
 * @author admin
 * @date 2020/2/13 13:09
 */
public class BakeMuttonCommand extends AbstractCommand {

    public BakeMuttonCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    void execute() {
        barbecuer.bakeMuttion();
    }
}
