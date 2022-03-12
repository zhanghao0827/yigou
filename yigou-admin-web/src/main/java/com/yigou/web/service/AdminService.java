package com.yigou.web.service;

import com.yigou.common.entity.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "yigou-admin")
public interface AdminService {

    @PostMapping("/admin/login")
    Admin login(@RequestBody Admin admin);
}
