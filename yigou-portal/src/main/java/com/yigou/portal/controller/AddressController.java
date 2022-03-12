package com.yigou.portal.controller;

import com.yigou.common.bean.Address;
import com.yigou.common.bean.CartBean;
import com.yigou.portal.service.AddressService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    AddressService addressService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/addr_info")
    public String address(Model model) {
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        List<Address> addresses = addressService.getAddressByUsername(username);
        Address defaultAddress = addressService.getDefaultAddressByUsername(username);
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        List<CartBean> carts = (ArrayList<CartBean>) redisTemplate.opsForValue().get(username);
        if (carts == null) {
            carts = new ArrayList<>();
        }
        int count = 0;
        double money = 0;
        for (CartBean cart : carts) {
            count = count * cart.getNum();
            money = money + (cart.getNum() * cart.getPrice());
        }
        model.addAttribute("carts", carts);
        model.addAttribute("addresses", addresses);
        model.addAttribute("defaultAddress", defaultAddress);
        model.addAttribute("count", count);
        model.addAttribute("money", money);
        return "order_info";
    }

    @GetMapping("/addr/{id}")
    @ResponseBody
    public Address getById(@PathVariable Integer id) {
        return addressService.getAddressById(id);
    }

}
