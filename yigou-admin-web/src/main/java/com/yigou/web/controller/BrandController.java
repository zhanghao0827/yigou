package com.yigou.web.controller;

import com.yigou.common.entity.Brand;
import com.yigou.common.util.PageUtils;
import com.yigou.common.util.Result;
import com.yigou.web.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/")
    public String getBrands(Model model) {
        List<Brand> brands = brandService.getBrands();
        model.addAttribute("brands", brands);
        return "brand";
    }

    @PostMapping("/")
    @ResponseBody
    public Result addBrand(Brand brand) {
        int i = brandService.addBrand(brand);
        if (i > 0) {
            return Result.success("新增成功!");
        }
        return Result.error("新增失败！");
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Brand getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/")
    @ResponseBody
    public Result updateBrand(Brand brand) {
        int i = brandService.updateBrand(brand);
        if (i > 0) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败！");
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteBrandById(@PathVariable Integer id) {
        int i = brandService.deleteBrandById(id);
        if (i > 0) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败！");
    }

    @DeleteMapping("/")
    @ResponseBody
    public Result deleteBatch(Integer[] ids) {
        int i = brandService.deleteBatch(ids);
        if (i > 0) {
            return Result.success("删除成功!");
        }
        return Result.error("删除失败！");
    }

    @GetMapping("/page")
    public String page(Model model, @RequestParam(defaultValue = "1", required = false) Integer pageIndex, @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        PageUtils<Brand> pageUtils = brandService.page(pageIndex, pageSize);
        model.addAttribute("pageUtils", pageUtils);
        return "brand";
    }


}
