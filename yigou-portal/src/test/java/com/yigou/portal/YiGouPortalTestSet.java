package com.yigou.portal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;

@SpringBootTest
public class YiGouPortalTestSet {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void test() {
        redisTemplate.boundSetOps("hobby").add("吸烟");
        redisTemplate.boundSetOps("hobby").add("喝酒");
        redisTemplate.boundSetOps("hobby").add("染发");
        redisTemplate.boundSetOps("hobby").add("赌博");
    }

    @Test
    public void test2() {
        Set<Object> hobby = redisTemplate.boundSetOps("hobby").members();
        System.out.println(hobby);
    }
}
