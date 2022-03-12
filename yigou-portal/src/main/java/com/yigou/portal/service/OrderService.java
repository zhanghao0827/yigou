package com.yigou.portal.service;

import com.yigou.common.bean.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("yigou-order")
public interface OrderService {

    @PostMapping("/order/")
    Integer addOrder(@RequestBody OrderInfo orderInfo);

}
