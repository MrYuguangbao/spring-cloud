package com.example.apigateway.facade;

/**
 * @author admin
 * @date 2020/3/1 14:20
 */
public class System1 {

    public boolean isValidAccount(Customer customer, int amount) {
        System.out.println("查询信息系统，用户：" + customer.getName());
        return true;
    }

}
