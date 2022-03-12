package com.yigou.portal.controller;

import com.yigou.common.util.IdWorker;
import com.yigou.common.util.Result;
import com.yigou.portal.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PayController {

    @Autowired
    PayService payService;

    @RequestMapping("/pay")
    public String pay(Model model) {
        IdWorker idWorker = new IdWorker();
        String out_trade_no = idWorker.nextId() + "";
        Map<String, String> map = payService.createNative(out_trade_no, "1");
        String code_url = map.get("code_url");
        Double total_fee = Double.valueOf(map.get("total_fee").toString());
        model.addAttribute("out_trade_no", out_trade_no);
        model.addAttribute("code_url", code_url);
        model.addAttribute("total_fee", total_fee);
        return "pay";
    }

    @RequestMapping("/queryPayStatus")
    @ResponseBody
    public Result queryPayStatus(String out_trade_no) {
        System.out.println("用户的订单编号是:" + out_trade_no);
        int count = 0;
        Result result;
        while (true) {
            System.out.println("--------->轮询微信支付接口,查询支付状态...........");
            //调用查询接口
            Map<String, String> map = payService.queryPayStatus(out_trade_no);
            System.out.println("------>查询接口:" + map);
            if (map == null) {
                result = Result.error("微信接口异常");
                break;
            }
            if (map.get("trade_state").equals("SUCCESS")) {
                System.out.println("支付成功");
                result = Result.success("支付成功");
                break;
            }
            try {
                Thread.sleep(4000); //间隔4秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count >= 100) {
                result = Result.error(505, "二维码超时");
            }
        }
        return result;
    }

    @RequestMapping("/paySuccess/{total_fee}")
    public String paySuccess(@PathVariable("total_fee") Double total_fee, Model model) {
        model.addAttribute("total_fee", total_fee);
        return "paySuccess";
    }

    @RequestMapping("/payFail")
    public String payFail() {
        System.out.println("支付失败");
        return "payFail";
    }

}
