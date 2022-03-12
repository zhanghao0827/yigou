package com.yigou.portal.controller;

import com.yigou.common.entity.CateMenu;
import com.yigou.portal.service.CateMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cate_menu")
public class CateMenuController {

    @Autowired
    CateMenuService cateMenuService;


}
