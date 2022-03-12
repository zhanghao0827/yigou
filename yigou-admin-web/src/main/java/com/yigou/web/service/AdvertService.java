package com.yigou.web.service;

import com.yigou.common.entity.Advert;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "yigou-advert")
public interface AdvertService {

    @GetMapping("/advert/")
    PageUtils<Advert> list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                           @RequestParam(defaultValue = "5", required = false) Integer pageSize);

    @PutMapping("/advert/status")
    int updateAdvertStatus(@RequestParam Integer id, @RequestParam Integer status);

    @PostMapping("/advert/")
    int addAdvert(@RequestBody Advert advert);

    @GetMapping("/advert/get/{id}")
    Advert getAdvertById(@PathVariable Integer id);

    @PutMapping("/advert/")
    int updateAdvert(@RequestBody Advert advert);
}
