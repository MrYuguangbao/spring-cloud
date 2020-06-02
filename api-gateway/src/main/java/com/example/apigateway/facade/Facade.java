package com.example.apigateway.facade;

/**
 * @author admin
 * @date 2020/3/1 14:20
 */
public class Facade {

    public System1 system1 = new System1();
    public System2 system2 = new System2();
    public System3 system3 = new System3();

    public boolean isPass(Customer customer, int amount) {
        System.out.println("顾客" + customer.getName() + "申请贷款:" + amount);
        boolean isPass = true;
        if (!system1.isValidAccount(customer, amount)) {
            isPass = false;
        } else if (!system2.isGoodCredit(customer, amount)) {
            isPass = false;
        } else if (!system3.isLoanCredit(customer, amount)) {
            isPass = false;
        }
        return isPass;
    }


}
