package com.yigou.statical.service;

import com.yigou.common.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("yigou-goods")
public interface ItemService {

    @GetMapping("/item/{goodsId}")
    List<Item> getItemsByGoodsId(@PathVariable Integer goodsId);
}
