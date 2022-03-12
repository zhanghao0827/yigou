package com.yigou.goods.controller;

import com.yigou.common.entity.Goods;
import com.yigou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/")
    public List<Goods> list(@RequestParam Integer isMarketable) {
        return goodsService.getAllGood(isMarketable);
    }

    @GetMapping("/{id}")
    public Goods getById(@PathVariable Integer id) {
        return goodsService.getGoodsById(id);
    }
}
