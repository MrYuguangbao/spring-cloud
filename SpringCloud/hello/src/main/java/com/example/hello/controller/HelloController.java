package com.example.hello.controller;

import com.example.hello.model.User;
import com.example.hello.util.MyDateTimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @author admin
 * @date 2020/2/5 17:23
 */
@RestController
public class HelloController {

    public static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Registration registration;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        /*List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        if (instances != null && instances.size()>0) {
            for (ServiceInstance instance : instances) {
                logger.info("[port]:"+instance.getPort());
                int time = new Random().nextInt(3000);
                logger.info("sleeptime:"+time);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String info = "host-port:"+instance.getUri()+",service_id:"+instance.getServiceId();
                System.out.println(info);
            }
        }*/
        String s = "hello service provider";
        return "调用服务提供者的hello接口,当前时间：" + MyDateTimeUtils.format(LocalDateTime.now());
    }

    @GetMapping(value = "/hello1")
    public String hello(@RequestParam String name) {
        return "Hello1 " + name;
    }

    @GetMapping(value = "/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping(value = "/hello3")
    public String hello(@RequestBody User user) {
        return "Hello3 " + user.getName() + ", " + user.getAge();
    }

    @GetMapping(value = "/index")
    public String testAcurator() {
        ResponseEntity<Object> forEntity = restTemplate.getForEntity("https://www.baidu.com", null, 1);
        System.out.println(forEntity);
        return "测试index";
    }

}
