package com.yigou.goods.service.impl;

import com.yigou.common.entity.Goods;
import com.yigou.goods.mapper.GoodsMapper;
import com.yigou.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public List<Goods> getAllGood(Integer isMarketable) {
        return goodsMapper.getAllGood(isMarketable);
    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsMapper.getGoodsById(id);
    }

}
