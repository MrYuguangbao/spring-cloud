package com.example.streamhello.stream;

/**
 * @author admin
 * @date 2020/3/10 18:14
 */
public class StreamUser {
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
        return "【StreamUser】：name = " + name + ",age = " + age;
    }

}
