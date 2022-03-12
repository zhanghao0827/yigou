package com.yigou.statical.service;

import com.yigou.common.entity.GoodsDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("yigou-goods")
public interface GoodsDetailService {

    @GetMapping("/goods_detail/{id}")
    GoodsDetail getById(@PathVariable Integer id);
}
