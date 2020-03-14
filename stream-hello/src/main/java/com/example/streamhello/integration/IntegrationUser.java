package com.example.streamhello.integration;

import java.io.Serializable;

/**
 * @author admin
 * @date 2020/3/10 18:03
 */
public class IntegrationUser implements Serializable {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "【IntegrationUser】：name=" + name + ",age=" + age;
    }
}
