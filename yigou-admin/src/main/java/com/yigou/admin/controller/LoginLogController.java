package com.yigou.admin.controller;

import com.yigou.admin.service.LoginLogService;
import com.yigou.common.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LoginLogController {

    @Autowired
    LoginLogService loginLogService;

    @PostMapping("/")
    public int addLoginLog(@RequestBody LoginLog loginLog) {
        return loginLogService.addLoginLog(loginLog);
    }

    @GetMapping("/")
    public List<LoginLog> getLoginLogs(String username) {
        return loginLogService.getLoginLogs(username);
    }


}
