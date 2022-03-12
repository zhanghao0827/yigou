package com.yigou.statical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class YiGouStaticApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiGouStaticApplication.class, args);
    }
}
