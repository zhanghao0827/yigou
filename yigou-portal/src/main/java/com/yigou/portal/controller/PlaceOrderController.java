package com.yigou.portal.controller;

import com.yigou.common.bean.OrderInfo;
import com.yigou.common.entity.Order;
import com.yigou.common.entity.OrderItem;
import com.yigou.common.util.IdWorker;
import com.yigou.common.util.Result;
import com.yigou.common.util.TimeUtils;
import com.yigou.portal.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/po")
public class PlaceOrderController {

    @Autowired
    PlaceOrderService placeOrderService;

    @RequestMapping("/xd")
    @ResponseBody
    public Result testXiaDan() {
        try {
            OrderInfo orderInfo = new OrderInfo();

            //模拟一个订单数据对象，原本应该从订单详情页面获取数据的！此处在模拟数据！
            Order order = new Order();
            order.setOrderId(new IdWorker().nextId());
            order.setUserId("zhanghao");
            order.setPaymentType("1");
            order.setStatus("1");
            order.setCreateTime(TimeUtils.getNow());
            order.setUpdateTime(TimeUtils.getNow());
            order.setReceiverAreaName("北京XXX洗浴中心");
            order.setReceiverMobile("13366789010");
            order.setReceiver("张昊");
            order.setSourceType("1");
            order.setPayment(2.0);

            //订单详情数据，模拟
            List<OrderItem> orderItems = new ArrayList<OrderItem>();
            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(1); //订单详情中sku商品ID  目前库存56
            orderItem.setGoodsId(1);
            orderItem.setOrderId(order.getOrderId());
            orderItem.setTitle("大牧汗精制肥牛片540g 原切谷饲牛肉 北京");
            orderItem.setPrice(3699.0);
            orderItem.setNum(2); //表示买2件
            orderItem.setTotalFee(orderItem.getNum() * orderItem.getPrice());
            orderItem.setPicPath("http://192.168.6.130:8866/group1/M00/00/00/wKgGglw950qAWTsOAACXPpn4lRU540.png");
            orderItem.setSellerId("zhanghao");
            orderItems.add(orderItem);
            orderInfo.setOrder(order);
            orderInfo.setOrderItems(orderItems);
            System.out.println(orderInfo);
            System.out.println(orderItems);
            int xiadan = placeOrderService.placeOrder(orderInfo, orderItems);
            System.out.println("下单：" + xiadan);
            return Result.success("下单成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return Result.error("下单异常");
    }


}
