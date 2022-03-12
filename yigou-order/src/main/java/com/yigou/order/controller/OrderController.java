package com.yigou.order.controller;

import com.yigou.common.bean.OrderInfo;
import com.yigou.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public Integer addOrder(@RequestBody OrderInfo orderInfo) {
        System.out.println("orderInfo = " + orderInfo);
        return orderService.addOrderInfo(orderInfo);
    }


}
