package com.yigou.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouOrderApplication.class, args);
    }
}
