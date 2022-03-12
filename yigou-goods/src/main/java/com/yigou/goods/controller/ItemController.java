package com.yigou.goods.controller;

import com.yigou.common.entity.Item;
import com.yigou.common.entity.OrderItem;
import com.yigou.goods.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/{goodsId}")
    public List<Item> getItemsByGoodsId(@PathVariable Integer goodsId) {
        return itemService.getItemsByGoodsId(goodsId);
    }

    @GetMapping("/id/{itemId}")
    public Item getById(@PathVariable Integer itemId) {
        return itemService.getItemById(itemId);
    }

    @PutMapping("/num")
    public int updateItemNum(@RequestBody List<OrderItem> orderItems) {
        return itemService.updateItemNum(orderItems);
    }

}
