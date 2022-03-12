package com.yigou.common.bean;

import com.yigou.common.entity.Order;
import com.yigou.common.entity.OrderItem;

import java.io.Serializable;
import java.util.List;

public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 6826244929335776516L;

    private Order order;
    private List<OrderItem> orderItems;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "order=" + order +
                ", orderItems=" + orderItems +
                '}';
    }
}
