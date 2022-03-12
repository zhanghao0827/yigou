package com.yigou.order.service.impl;

import com.yigou.common.bean.OrderInfo;
import com.yigou.common.entity.OrderItem;
import com.yigou.order.mapper.OrderMapper;
import com.yigou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    /**
     * 事务操作
     */
    @Transactional
    @Override
    public int addOrderInfo(OrderInfo orderInfo) {
        orderMapper.addOrder(orderInfo.getOrder());
        List<OrderItem> orderItems = orderInfo.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            orderMapper.addOrderItem(orderItem);
        }
        return 1;
    }

}
