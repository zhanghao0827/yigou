package com.yigou.goods.service;

import com.yigou.common.entity.Goods;

import java.util.List;

public interface GoodsService {

    List<Goods> getAllGood(Integer isMarketable);

    Goods getGoodsById(Integer id);
}
