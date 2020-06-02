package com.example.ribbonconsumer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @date 2020/2/7 14:12
 */
@Service
public class HelloService {


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService() {
        long start = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class);
        String jsonResult = JSON.toJSONString(response);
        long end = System.currentTimeMillis();
        System.out.println("spend time:" + (end - start));
        return jsonResult;
    }

    public String helloFallback() {
        return "helloFallback error!";
    }
}
