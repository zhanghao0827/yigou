package com.yigou.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YiGouGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouGoodsApplication.class, args);
    }
}
