package com.yigou.web.controller;

import com.yigou.common.entity.Admin;
import com.yigou.common.entity.LoginLog;
import com.yigou.common.util.Result;
import com.yigou.web.service.AdminService;
import com.yigou.web.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    LoginLogService loginLogService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(Admin admin, String ip, String city, HttpServletRequest request) {
        Admin login = adminService.login(admin);
        if (login == null) {
            return Result.error("登录失败！");
        } else {
            if ("0".equals(login.getStatus())) {
                return Result.error(405, "账户被禁用！");
            }
            //拿到用户ip和地址
            LoginLog loginLog = new LoginLog(admin.getUsername(), ip, city);
            loginLogService.addLoginLog(loginLog);
            request.getSession().setAttribute("admin", login);
            return Result.success("登录成功！");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.getWriter().write("<script>location.href='/page_login';</script>");
    }

}
