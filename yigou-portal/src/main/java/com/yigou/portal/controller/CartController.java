package com.yigou.portal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yigou.common.bean.CartBean;
import com.yigou.common.entity.Item;
import com.yigou.common.util.Result;
import com.yigou.portal.service.ItemService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    ItemService itemService;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/cart_add")
    @ResponseBody
    public Result addCart(Integer itemId, Integer num, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String cookie = this.getCookie("yigou-cart", request);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CartBean> cartLists = objectMapper.readValue(cookie, new TypeReference<ArrayList<CartBean>>() {
        });
        if (principal == null) {
            cartLists = this.addCarts(itemId, num, cartLists);
            //购物车存到Cookie
            String cartJson = objectMapper.writeValueAsString(cartLists);
            this.setCookie("yigou-cart", cartJson, response);
        } else {
            String loginName = principal.toString();
            cartLists = this.addCarts(itemId, num, cartLists);
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            List<CartBean> cartBeans = (ArrayList<CartBean>) redisTemplate.opsForValue().get(loginName);//使用用户名作为key
            if (cartBeans == null) {
                cartBeans = new ArrayList<>();
            }
            List<CartBean> mergeCartList = this.mergeCartList(cartBeans, cartLists);
            redisTemplate.opsForValue().set(loginName, mergeCartList);
            //清空Cookie
            this.clearCookie("yigou-cart", response);
        }
        return Result.success("添加购物车成功！");
    }


    public List<CartBean> mergeCartList(List<CartBean> redisCarts, List<CartBean> cookieCarts) {
        List<CartBean> resultCarts = new ArrayList<>();
        for (CartBean redisCart : redisCarts) {
            Boolean exist = this.isExist(resultCarts, redisCart.getItemId());
            if (!exist) {
                resultCarts.add(redisCart);
            } else {
                for (CartBean resultCart : resultCarts) {
                    if (resultCart.getItemId().toString().equals(redisCart.getItemId().toString())) {
                        resultCart.setNum(resultCart.getNum() + redisCart.getNum());
                        resultCart.setTotalFee(resultCart.getNum() * resultCart.getPrice());
                    }
                }
            }
        }
        for (CartBean redisCart : cookieCarts) {
            Boolean exist = this.isExist(resultCarts, redisCart.getItemId());
            if (!exist) {
                resultCarts.add(redisCart);
            } else {
                for (CartBean resultCart : resultCarts) {
                    if (resultCart.getItemId().toString().equals(redisCart.getItemId().toString())) {
                        resultCart.setNum(resultCart.getNum() + redisCart.getNum());
                        resultCart.setTotalFee(resultCart.getNum() * resultCart.getPrice());
                    }
                }
            }
        }
        return resultCarts;
    }

    @RequestMapping("/cart_show")
    public String showCart(HttpServletRequest request,HttpServletResponse response, Model model) throws JsonProcessingException {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String cookie = this.getCookie("yigou-cart", request);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CartBean> cartLists = objectMapper.readValue(cookie, new TypeReference<ArrayList<CartBean>>() {
        });
        if (principal == null) {
            model.addAttribute("carts", cartLists);
        } else {
            //登录下查看redis中的数据
            String loginName = principal.toString();
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            List<CartBean> cartBeans = (ArrayList<CartBean>) redisTemplate.opsForValue().get(loginName);//使用用户名作为key
            if (cartBeans == null) {
                cartBeans = new ArrayList<>();//防止为空
            }
            List<CartBean> mergeCartList = this.mergeCartList(cartBeans, cartLists);
            redisTemplate.opsForValue().set(loginName, mergeCartList);
            model.addAttribute("carts", mergeCartList);
            this.clearCookie("yigou-cart",response);
        }
        return "cart";
    }

    @RequestMapping("/cart_delete")
    @ResponseBody
    public Result cart_delete(Integer id, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        String cookie = this.getCookie("yigou-cart", request);
        ObjectMapper objectMapper = new ObjectMapper();
        List<CartBean> cartLists = objectMapper.readValue(cookie, new TypeReference<ArrayList<CartBean>>() {
        });
        if (principal == null) {
            //非登录下删除Cookie
            cartLists = deleteCart(cartLists, id);
            String cartJson = objectMapper.writeValueAsString(cartLists);
            this.setCookie("yigou-cart", cartJson, response);
        } else {
            //登录状态下删除Redis
            String loginName = principal.toString();
            redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
            List<CartBean> redisCartBeans = (ArrayList<CartBean>) redisTemplate.opsForValue().get(loginName);//使用用户名作为key
            if (redisCartBeans == null) {
                redisCartBeans = new ArrayList<>();//防止为空
            }
            //移除之后存入(重置)Redis
            redisCartBeans = this.deleteCart(redisCartBeans, id);
            redisTemplate.opsForValue().set(loginName, redisCartBeans);
        }
        return Result.success("删除成功!");
    }

    public List<CartBean> deleteCart(List<CartBean> cartBeans, Integer cartId) {
        List<CartBean> carts = new ArrayList<>();
        for (CartBean cartBean : cartBeans) {
            if (!cartBean.getItemId().toString().equals(cartId.toString())) {
                carts.add(cartBean);
            }
        }
        return carts;
    }

    public void setCookie(String key, String value, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public String getCookie(String key, HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (key.equals(cookie.getName())) {
                        return URLDecoder.decode(cookie.getValue(), "UTF-8");
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "[]";//防止空指针
    }

    public void clearCookie(String key, HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode("[]", "UTF-8"));
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public List<CartBean> addCarts(Integer itemId, Integer num, List<CartBean> cartBeans) {
        Boolean exist = isExist(cartBeans, itemId);
        if (!exist) {
            CartBean cartBean = new CartBean();
            Item item = itemService.getById(itemId);
            cartBean.setItemId(itemId);
            cartBean.setGoodsId(item.getGoodsId());
            cartBean.setTitle(item.getTitle());
            cartBean.setPrice(item.getPrice());
            cartBean.setNum(num);
            cartBean.setTotalFee(item.getPrice() * item.getNum());
            cartBean.setSellerId(item.getSellerId());
            cartBean.setPicPath(item.getImage());
            cartBeans.add(cartBean);
        } else {
            for (CartBean cartBean : cartBeans) {
                if (cartBean.getItemId().toString().equals(itemId.toString())) {
                    cartBean.setNum(cartBean.getNum() + num);
                    cartBean.setTotalFee(cartBean.getPrice() * cartBean.getNum());
                }
            }
        }
        return cartBeans;
    }

    public Boolean isExist(List<CartBean> cartBeans, Integer itemId) {
        for (CartBean cartBean : cartBeans) {
            if (cartBean.getItemId().toString().equals(itemId.toString())) {
                return true;
            }
        }
        return false;
    }


}
