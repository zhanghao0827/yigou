package com.yigou.portal.service;

import com.yigou.common.entity.CateMenu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("yigou-catemenu")
public interface CateMenuService {

    @GetMapping("/cate_menu/all")
    List<CateMenu> getCateMenus();
}
