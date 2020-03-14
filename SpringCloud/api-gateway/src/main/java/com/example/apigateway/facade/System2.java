package com.example.apigateway.facade;

/**
 * @author admin
 * @date 2020/3/1 14:20
 */
public class System2 {

    public boolean isGoodCredit(Customer customer, int amount) {
        System.out.println("查询信用系统，用户：" + customer.getName());
        return true;
    }

}
