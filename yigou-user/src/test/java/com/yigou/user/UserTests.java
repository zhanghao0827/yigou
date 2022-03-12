package com.yigou.user;
import com.yigou.common.entity.User;
import com.yigou.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {

    @Autowired
    UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("张昊");
        user.setPassword("123");
        user.setPhone("12101919011");
        user.setEmail("123@qq.com");
        user.setNickName("zhanghao");
        user.setName("张昊");
        user.setQq("19109111");
        user.setSex("男");
        int i = userService.addUser(user);
        System.out.println(i);
    }
}
