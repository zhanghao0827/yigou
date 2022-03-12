package com.yigou.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouUserApplication.class, args);
    }
}
