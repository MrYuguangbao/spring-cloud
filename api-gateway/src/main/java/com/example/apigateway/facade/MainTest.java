package com.example.apigateway.facade;

/**
 * @author admin
 * @date 2020/3/1 14:29
 */
public class MainTest {


    public static void main(String[] args) {
        Facade facade = new Facade();
        Customer customer = new Customer("小季", 10000);

        boolean pass = facade.isPass(customer, 20000);
        System.out.println("客户" + customer.getName() + (pass ? "通过" : "不通过"));

    }
}
