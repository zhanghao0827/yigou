package com.yigou.goods.service;

import com.yigou.common.entity.Item;
import com.yigou.common.entity.OrderItem;

import java.util.List;

public interface ItemService {

    List<Item> getItemsByGoodsId(Integer goodsId);

    Item getItemById(Integer itemId);

    int updateItemNum(List<OrderItem> orderItems);
}
