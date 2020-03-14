package com.example.rabbitmqhello;

import com.example.rabbitmqhello.sender.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqHelloApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }

    @Test
    void contextLoads() {
        System.out.println("contextLoads");
    }

}
