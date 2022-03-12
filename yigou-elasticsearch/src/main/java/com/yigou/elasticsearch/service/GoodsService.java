package com.yigou.elasticsearch.service;

import com.yigou.common.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("yigou-goods")
public interface GoodsService {

    @GetMapping("/goods/")
    List<Goods> getAllGood(@RequestParam Integer isMarketable);
}
