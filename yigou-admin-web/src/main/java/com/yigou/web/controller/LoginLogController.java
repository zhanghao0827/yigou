package com.yigou.web.controller;

import com.yigou.common.entity.Admin;
import com.yigou.common.entity.LoginLog;
import com.yigou.web.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/log")
public class LoginLogController {

    @Autowired
    LoginLogService loginLogService;

    @PostMapping("/")
    public int log(LoginLog loginLog) {
        return loginLogService.addLoginLog(loginLog);
    }

    @GetMapping("/")
    public List<LoginLog> log(HttpServletRequest request) {
        String username = ((Admin) request.getSession().getAttribute("admin")).getUsername();
        return loginLogService.getLoginLogs(username);
    }


}
