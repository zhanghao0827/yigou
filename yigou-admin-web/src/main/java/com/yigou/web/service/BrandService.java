package com.yigou.web.service;

import com.yigou.common.entity.Brand;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "yigou-brand")
public interface BrandService {

    @GetMapping("/brand/")
    List<Brand> getBrands();

    @PostMapping("/brand/")
    int addBrand(@RequestBody Brand brand);

    @PutMapping("/brand/")
    int updateBrand(@RequestBody Brand brand);

    @GetMapping("/brand/{id}")
    Brand getBrandById(@PathVariable Integer id);

    @DeleteMapping("/brand/{id}")
    int deleteBrandById(@PathVariable Integer id);

    /**
     * 凡是 key/value 形式的参数，一定要标记参数的名
     */
    @DeleteMapping("/brand/")
    int deleteBatch(@RequestParam("ids") Integer[] ids);

    @GetMapping("/brand/page")
    PageUtils<Brand> page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex, @RequestParam(defaultValue = "5", required = false) Integer pageSize);

}