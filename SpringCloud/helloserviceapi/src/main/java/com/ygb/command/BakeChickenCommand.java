package com.ygb.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author admin
 * @date 2020/2/13 13:10
 */
public class BakeChickenCommand extends AbstractCommand {

    public BakeChickenCommand(Barbecuer barbecuer) {
        super(barbecuer);
    }

    @Override
    void execute() {
        barbecuer.bakeChicken();
    }

    public static void main(String[] args) {


    }

}
