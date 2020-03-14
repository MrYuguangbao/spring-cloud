package com.example.apigateway;

import com.example.apigateway.filter.AccessFilter;
import com.example.apigateway.filter.ThrowExceptionFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    //@Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public ThrowExceptionFilter exceptionFilter() {
        return new ThrowExceptionFilter();
    }

    @Bean
    public PatternServiceRouteMapper getRouteMapper() {
        return new PatternServiceRouteMapper("", "");
    }

}
