package com.yigou.goods.service.impl;

import com.yigou.common.entity.Item;
import com.yigou.common.entity.OrderItem;
import com.yigou.goods.mapper.ItemMapper;
import com.yigou.goods.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 实现标记接口ITxTransaction
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> getItemsByGoodsId(Integer goodsId) {
        return itemMapper.getItemsByGoodsId(goodsId);
    }

    @Override
    public Item getItemById(Integer itemId) {
        return itemMapper.getItemById(itemId);
    }

    @Transactional
    @Override
    public int updateItemNum(List<OrderItem> orderItems) {
        System.out.println("orderItems = " + orderItems);
        for (OrderItem orderItem : orderItems) {
            int i = itemMapper.updateItemNum(orderItem);
            System.out.println("i = " + i);
        }
        return 1;
    }



}
