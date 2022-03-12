package com.yigou.web.service;

import com.yigou.common.entity.CateMenu;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("yigou-catemenu")
public interface CateMenuService {

    @GetMapping("/cate_menu/")
    PageUtils<CateMenu> list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                             @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                             @RequestParam(defaultValue = "0", required = false) Integer parentId);

    @GetMapping("/cate_menu/{id}")
    CateMenu getCateMenuById(@PathVariable Integer id);

    @GetMapping("/cate_menu/all")
    List<CateMenu> getCateMenus();

    @PostMapping("/cate_menu/")
    int addCateMenu(@RequestBody CateMenu cateMenu);

    @PutMapping("/cate_menu/")
    int updateCateMenu(@RequestBody CateMenu cateMenu);
}
