package com.yigou.portal.controller;

import com.yigou.portal.config.CasConfig;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

    @Autowired
    CasConfig casConfig;

    @RequestMapping("/member_user")
    public String user() {
        return "member_user";
    }

    /**
     * 登出
     *
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/member_logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes attributes) {
        SecurityUtils.getSubject().logout();
        attributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:" + casConfig.getCasServerLogoutUrl();
    }
    
    @GetMapping("/member_login")
    public String login() {
        return "redirect:member_user";
    }

}
