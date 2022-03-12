package com.yigou.goods.mapper;

import com.yigou.common.entity.Item;
import com.yigou.common.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> getItemsByGoodsId(Integer goodsId);

    Item getItemById(Integer itemId);

    int updateItemNum(OrderItem orderItem);

}
