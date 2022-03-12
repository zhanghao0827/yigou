package com.yigou.brand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouBrandApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiGouBrandApplication.class, args);
    }
}
