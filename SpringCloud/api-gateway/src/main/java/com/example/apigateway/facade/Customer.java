package com.example.apigateway.facade;

/**
 * @author admin
 * @date 2020/3/1 14:21
 */
public class Customer {

    private String name;
    private int amount;

    public Customer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
