package com.yigou.portal.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroDialectConfig {

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect ();
    }

}
