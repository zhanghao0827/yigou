package com.yigou.pay.controller;

import com.github.wxpay.sdk.WXPayUtil;
import com.yigou.common.util.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Value("${appid}")
    private String appid;

    @Value("${partner}")
    private String partner;

    @Value("${partnerkey}")
    private String partnerkey;

    @Value("${notifyurl}")
    private String notifyurl;

    /**
     * 生成二维码
     */
    @RequestMapping("/createNative")
    public Map<String, String> createNative(@RequestParam("out_trade_no") String out_trade_no, @RequestParam("total_fee") String total_fee) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);// 公众号
        param.put("mch_id", partner);// 商户号
        param.put("nonce_str", WXPayUtil.generateNonceStr());// 随机字符串
        param.put("body", "yigou商城");// 商品描述
        param.put("out_trade_no", out_trade_no);// 商户订单号
        param.put("total_fee", total_fee);// 总金额（分）
        param.put("spbill_create_ip", "127.0.0.1");// IP
        param.put("notify_url", notifyurl);// 回调地址(随便写)
        param.put("trade_type", "NATIVE");// 交易类型
        try {
            // 2.生成要发送的xml
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            System.out.println(xmlParam);
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            client.setHttps(true);
            client.setXmlParam(xmlParam);
            client.post();
            // 3.获得结果
            String result = client.getContent();
            System.out.println(result);
            Map<String, String> resultMap = WXPayUtil.xmlToMap(result);
            Map<String, String> map = new HashMap<>();
            map.put("code_url", resultMap.get("code_url"));// 支付地址
            map.put("total_fee", total_fee);// 总金额
            map.put("out_trade_no", out_trade_no);// 订单号
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    /**
     * 查询接口支付状态  没间隔一段时间轮询接口，获取该订单的状态
     */
    @RequestMapping("/queryPayStatus")
    public Map<String, String> queryPayStatus(@RequestParam("out_trade_no") String out_trade_no) {
        Map<String, String> param = new HashMap<>();
        param.put("appid", appid);// 公众账号ID
        param.put("mch_id", partner);// 商户号
        param.put("out_trade_no", out_trade_no);// 订单号
        param.put("nonce_str", WXPayUtil.generateNonceStr());// 随机字符串
        String url = "https://api.mch.weixin.qq.com/pay/orderquery";  //查询订单接口
        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            HttpClient client = new HttpClient(url);
            client.setHttps(true);
            client.setXmlParam(xmlParam);
            client.post();
            //获取接口的返回结果
            String result = client.getContent();  //接口的返回结果
            return WXPayUtil.xmlToMap(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
