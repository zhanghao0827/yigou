package com.yigou.order.mapper;

import com.yigou.common.entity.Order;
import com.yigou.common.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int addOrder(Order order);

    int addOrderItem(OrderItem orderItem);
}
