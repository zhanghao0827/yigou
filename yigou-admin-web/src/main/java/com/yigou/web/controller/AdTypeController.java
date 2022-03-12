package com.yigou.web.controller;

import com.yigou.common.entity.AdType;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.AdTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ad_type")
public class AdTypeController {

    @Autowired
    AdTypeService adTypeService;

    @GetMapping("/")
    public String getAdTypeList(@RequestParam(defaultValue = "1") Integer pageIndex,
                                @RequestParam(defaultValue = "5") Integer pageSize,
                                @RequestParam(defaultValue = "") String name, Model model) {
        PageUtils<AdType> pageUtils = adTypeService.getAdTypeList(pageIndex, pageSize, name);
        model.addAttribute("pageUtils", pageUtils);
        model.addAttribute("name", name);
        return "ad_type";
    }

    @PostMapping("/")
    @ResponseBody
    public Result addAdType(AdType adType) {
        int i = adTypeService.addAdType(adType);
        if (i > 0) {
            return Result.success("新增成功！");
        }
        return Result.error("新增失败！");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public AdType getById(@PathVariable Integer id) {
        return adTypeService.getAdTypeById(id);
    }


    @PutMapping("/")
    @ResponseBody
    public Result updateAdType(AdType adType) {
        int i = adTypeService.updateAdType(adType);
        if (i > 0) {
            return Result.success("新增成功！");
        }
        return Result.error("新增失败！");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteAdTypeById(@PathVariable Integer id) {
        int i = adTypeService.deleteAdTypeById(id);
        if (i > 0) {
            return Result.success("删除成功！");
        }
        return Result.error("删除失败！");
    }

    @GetMapping("/all")
    @ResponseBody
    public List<AdType> getAdTypes() {
        return adTypeService.getAdTypes();
    }

}
