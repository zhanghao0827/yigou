package com.yigou.brand.controller;

import com.yigou.brand.service.BrandService;
import com.yigou.common.entity.Brand;
import com.yigou.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/")
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @PostMapping("/")
    public int addBrand(@RequestBody Brand brand) {
        return brandService.addBrand(brand);
    }

    @PutMapping("/")
    public int updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @DeleteMapping("/{id}")
    public int updateBrand(@PathVariable Integer id) {
        return brandService.deleteBrandById(id);
    }

    @DeleteMapping("/")
    public int updateBrand(Integer[] ids) {
        return brandService.deleteBatch(ids);
    }

    @GetMapping("/page")
    public PageUtils<Brand> page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex, @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        int count = brandService.getTotalCount();
        List<Brand> brands = brandService.getBrandListByPage((pageIndex - 1) * pageSize, pageSize);
        return new PageUtils<>(pageIndex, pageSize, count, brands);
    }


}
