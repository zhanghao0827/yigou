package com.yigou.portal.service;

import com.yigou.common.entity.Item;
import com.yigou.common.entity.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("yigou-goods")
public interface ItemService {

    @GetMapping("/item/id/{itemId}")
    Item getById(@PathVariable Integer itemId);

    @PutMapping("/item/num")
    int updateItemNum(@RequestBody List<OrderItem> orderItems);
}
