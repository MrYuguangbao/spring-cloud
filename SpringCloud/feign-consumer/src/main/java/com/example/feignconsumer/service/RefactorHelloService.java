package com.example.feignconsumer.service;

import com.example.feignconsumer.feign.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author admin
 * @date 2020/2/8 14:53
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.ygb.service.HelloService {
}
