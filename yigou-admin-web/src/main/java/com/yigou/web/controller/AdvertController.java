package com.yigou.web.controller;

import com.yigou.common.entity.Advert;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    AdvertService advertService;

    @GetMapping("/")
    public String list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                       @RequestParam(defaultValue = "5", required = false) Integer pageSize, Model model) {
        PageUtils<Advert> pageUtils = advertService.list(pageIndex, pageSize);
        model.addAttribute("pageUtils", pageUtils);
        return "advert";
    }

    @PutMapping("/status")
    @ResponseBody
    public Result updateAdvertStatus(Integer id, Integer status) {
        int i = advertService.updateAdvertStatus(id, status);
        if (i > 0) {
            return Result.success("更新状态成功!");
        }
        return Result.error("更新状态失败!");
    }

    @PostMapping("/")
    @ResponseBody
    public Result updateAdvertStatus(Advert advert) {
        int i = advertService.addAdvert(advert);
        if (i > 0) {
            return Result.success("新增成功!");
        }
        return Result.error("新增失败!");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Advert getAdvertById(@PathVariable Integer id) {
        return advertService.getAdvertById(id);
    }

    @PutMapping("/")
    @ResponseBody
    public Result updateAdvert(Advert advert) {
        int i = advertService.updateAdvert(advert);
        if (i > 0) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }


}
