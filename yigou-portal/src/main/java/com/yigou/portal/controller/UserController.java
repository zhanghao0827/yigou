package com.yigou.portal.controller;

import com.yigou.common.entity.User;
import com.yigou.common.util.Result;
import com.yigou.common.util.StringUtil;
import com.yigou.portal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    @ResponseBody
    public Result register(User user) {
        user.setPassword(StringUtil.MD5Encode(user.getPassword() + "easyhao").toLowerCase());
        int i = userService.addUser(user);
        if (i > 0) {
            return Result.success("注册成功！", i);
        }
        return Result.error("注册失败！");
    }
}
