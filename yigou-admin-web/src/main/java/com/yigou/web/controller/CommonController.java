package com.yigou.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping({"/", "/admin"})
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/page_{page}")
    public String page(@PathVariable String page) {
        return page;
    }

}
