package com.yigou.portal.service;


import com.yigou.common.entity.Advert;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("yigou-advert")
public interface AdvertService {

    @GetMapping("/advert/{id}")
    List<Advert> getAdvertByTypeId(@PathVariable Integer id);
}
