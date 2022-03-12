package com.yigou.admin.controller;

import com.yigou.admin.service.AdminService;
import com.yigou.common.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.selectAdmin(admin);
    }


}
