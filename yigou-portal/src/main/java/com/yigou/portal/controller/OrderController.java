package com.yigou.portal.controller;

import com.yigou.common.bean.CartBean;
import com.yigou.common.bean.OrderInfo;
import com.yigou.common.entity.Order;
import com.yigou.common.entity.OrderItem;
import com.yigou.common.util.IdWorker;
import com.yigou.common.util.Result;
import com.yigou.common.util.TimeUtils;
import com.yigou.portal.service.OrderService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/order_add")
    @ResponseBody
    public Result addOrder(Order order) {
        System.out.println("order = " + order);
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        List<CartBean> carts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(username);//使用用户名作为key
        if (carts == null) {
            carts = new ArrayList<>();//防止为空
        }
        IdWorker idWorker = new IdWorker();
        order.setOrderId(idWorker.nextId());
        order.setUserId(username);
        order.setStatus("1");
        order.setCreateTime(TimeUtils.getNow());
        order.setUpdateTime(TimeUtils.getNow());
        order.setSourceType("2");

        double money=0;
        for (CartBean cart : carts) {
            cart.setOrderId(order.getOrderId());
            cart.setSellerId(order.getSellerId());
            money = money + cart.getNum() + cart.getPrice();
        }
        order.setPayment(money);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartBean cart : carts) {
            OrderItem orderItem = new OrderItem();
            orderItem.setTitle(cart.getTitle());
            orderItem.setSellerId(cart.getSellerId());
            orderItem.setTotalFee(cart.getTotalFee());
            orderItem.setNum(cart.getNum());
            orderItem.setPicPath(cart.getPicPath());
            orderItem.setGoodsId(cart.getGoodsId());
            orderItem.setPrice(cart.getPrice());
            orderItem.setItemId(cart.getItemId());
            orderItem.setOrderId(cart.getOrderId());
            orderItems.add(orderItem);
        }

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrder(order);
        orderInfo.setOrderItems(orderItems);

        Integer i = orderService.addOrder(orderInfo);
        if (i > 0) {
            return Result.success("下单成功！");
        }
        return Result.error("下单失败！");
    }

}
