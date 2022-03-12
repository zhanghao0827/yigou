package com.yigou.portal.service;

import com.yigou.common.bean.OrderInfo;
import com.yigou.common.entity.OrderItem;

import java.util.List;

public interface PlaceOrderService {

    int placeOrder(OrderInfo orderInfo, List<OrderItem> orderItems);
}
