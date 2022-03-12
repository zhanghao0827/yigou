package com.yigou.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YiGouElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouElasticsearchApplication.class, args);
    }
}
