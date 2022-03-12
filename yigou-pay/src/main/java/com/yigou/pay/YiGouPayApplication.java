package com.yigou.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouPayApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouPayApplication.class, args);
    }
}
