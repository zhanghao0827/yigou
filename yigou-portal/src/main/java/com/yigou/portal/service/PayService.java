package com.yigou.portal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("yigou-pay")
public interface PayService {

    @RequestMapping("/pay/createNative")
    Map<String, String> createNative(@RequestParam("out_trade_no") String out_trade_no, @RequestParam("total_fee") String total_fee);

    @RequestMapping("/pay/queryPayStatus")
    Map<String, String> queryPayStatus(@RequestParam("out_trade_no") String out_trade_no);
}
