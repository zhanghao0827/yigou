package com.yigou.web.service;

import com.yigou.common.entity.LoginLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "yigou-admin")
public interface LoginLogService {

    @PostMapping("/log/")
    int addLoginLog(@RequestBody LoginLog loginLog);

    @GetMapping("/log/")
    List<LoginLog> getLoginLogs(@RequestParam String username);
}
