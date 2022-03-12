package com.yigou.goods.controller;

import com.yigou.common.entity.GoodsDetail;
import com.yigou.goods.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods_detail")
public class GoodsDetailController {

    @Autowired
    GoodsDetailService goodsDetailService;

    @GetMapping("/{id}")
    public GoodsDetail getById(@PathVariable Integer id) {
        return goodsDetailService.getById(id);
    }
}
