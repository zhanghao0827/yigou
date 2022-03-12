package com.yigou.portal.service.impl;

import com.yigou.common.bean.OrderInfo;
import com.yigou.common.entity.OrderItem;
import com.yigou.portal.service.ItemService;
import com.yigou.portal.service.OrderService;
import com.yigou.portal.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Transactional
    public int placeOrder(OrderInfo orderInfo, List<OrderItem> orderItems) {
        Integer i = orderService.addOrder(orderInfo);
        System.out.println(i);
        int j = itemService.updateItemNum(orderItems);
        System.out.println(j);
        return i + j;
    }
}
