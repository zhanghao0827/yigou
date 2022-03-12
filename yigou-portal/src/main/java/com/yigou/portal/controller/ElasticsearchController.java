package com.yigou.portal.controller;

import com.yigou.common.entity.Goods;
import com.yigou.common.util.PageUtils;
import com.yigou.portal.service.ElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ElasticsearchController {

    @Autowired
    ElasticsearchService elasticsearchService;

    @GetMapping("/list")
    public String page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                       @RequestParam(defaultValue = "12", required = false) Integer pageSize,
                       @RequestParam(defaultValue = "", required = false) String keyword, Model model) {
        PageUtils<Goods> pageUtils = elasticsearchService.page(pageIndex, pageSize, keyword);
        model.addAttribute("pageUtils", pageUtils);
        model.addAttribute("keyword", keyword);
        return "goods_list";
    }

}
