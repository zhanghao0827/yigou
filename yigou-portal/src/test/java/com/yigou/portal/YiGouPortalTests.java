package com.yigou.portal;

import com.yigou.common.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class YiGouPortalTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    public void test() {
        System.out.println(redisTemplate);
        System.out.println(stringRedisTemplate);
    }

    @Test
    public void test1() {
        redisTemplate.opsForValue().set("username", "张昊", 20, TimeUnit.SECONDS);
    }

    @Test
    public void test2() {
        String username = (String) redisTemplate.opsForValue().get("username");
        System.out.println(username);
    }

    @Test
    public void test3() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("张昊");
        admin.setPassword("123");
        admin.setStatus("1");
        admin.setPhoto("abc.jpg");
        admin.setDel(0);
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set("admin", admin);
    }

    @Test
    public void test4() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get("admin");
        System.out.println(admin);
    }

    @Test
    public void test5() {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("张昊");
        admin.setPassword("123");
        admin.setStatus("1");
        admin.setPhoto("abc.jpg");
        admin.setDel(0);
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Admin.class));
        redisTemplate.opsForValue().set("admin2", admin);
    }

    @Test
    public void test6() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Admin.class));
        Admin admin = (Admin) redisTemplate.opsForValue().get("admin2");
        System.out.println(admin);
    }
}
