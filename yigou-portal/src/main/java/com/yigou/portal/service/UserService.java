package com.yigou.portal.service;

import com.yigou.common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("yigou-user")
public interface UserService {

    @PostMapping("/user/")
    int addUser(@RequestBody User user);

}
