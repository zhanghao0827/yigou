package com.yigou.goods.service.impl;

import com.yigou.common.entity.GoodsDetail;
import com.yigou.goods.mapper.GoodsDetailMapper;
import com.yigou.goods.service.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    GoodsDetailMapper goodsDetailMapper;

    @Override
    public GoodsDetail getById(Integer id) {
        return goodsDetailMapper.getById(id);
    }
}
