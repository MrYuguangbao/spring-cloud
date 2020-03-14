package com.example.hello;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@Run
@SpringBootTest
class HelloApplicationTests {

    private MockMvc mockMvc;

    //@Before


    @Test
    void contextLoads() {
        System.out.println("单元测试，调用contextLoads方法");
    }

}
