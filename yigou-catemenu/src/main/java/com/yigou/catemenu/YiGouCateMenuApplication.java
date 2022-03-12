package com.yigou.catemenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouCateMenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouCateMenuApplication.class, args);
    }
}
