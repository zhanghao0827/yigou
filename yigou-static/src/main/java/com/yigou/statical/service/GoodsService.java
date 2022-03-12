package com.yigou.statical.service;

import com.yigou.common.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("yigou-goods")
public interface GoodsService {

    @GetMapping("/goods/{id}")
    Goods getById(@PathVariable Integer id);
}
