package com.yigou.goods.mapper;

import com.yigou.common.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> getAllGood(Integer isMarketable);

    Goods getGoodsById(Integer id);
}
