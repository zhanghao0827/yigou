package com.yigou.statical.service;

import com.yigou.common.entity.CateMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("yigou-catemenu")
public interface CateMenuService {

    @GetMapping("/cate_menu/{id}")
    CateMenu getCateMenuById(@PathVariable Integer id);
}
