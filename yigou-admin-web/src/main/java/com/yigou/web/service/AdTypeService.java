package com.yigou.web.service;

import com.yigou.common.entity.AdType;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "yigou-advert")
public interface AdTypeService {

    @GetMapping("/ad_type/")
    PageUtils<AdType> getAdTypeList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                    @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                    @RequestParam(defaultValue = "", required = false) String name);

    @PostMapping("/ad_type/")
    int addAdType(@RequestBody AdType adType);

    @PutMapping("/ad_type/")
    int updateAdType(@RequestBody AdType adType);

    @DeleteMapping("/ad_type/{id}")
    int deleteAdTypeById(@PathVariable Integer id);

    @GetMapping("/ad_type/{id}")
    AdType getAdTypeById(@PathVariable Integer id);

    @GetMapping("/ad_type/all")
    List<AdType> getAdTypes();

}
