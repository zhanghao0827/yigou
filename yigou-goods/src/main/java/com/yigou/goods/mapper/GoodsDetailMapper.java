package com.yigou.goods.mapper;

import com.yigou.common.entity.GoodsDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDetailMapper {

    GoodsDetail getById(Integer id);
}
