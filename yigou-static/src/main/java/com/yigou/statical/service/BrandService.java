package com.yigou.statical.service;

import com.yigou.common.entity.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("yigou-brand")
public interface BrandService {

    @GetMapping("/brand/{id}")
    Brand getBrandById(@PathVariable Integer id);
}
