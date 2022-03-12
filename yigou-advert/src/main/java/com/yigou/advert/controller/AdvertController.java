package com.yigou.advert.controller;

import com.yigou.advert.service.AdvertService;
import com.yigou.common.entity.Advert;
import com.yigou.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/advert")
public class AdvertController {

    @Autowired
    AdvertService advertService;

    @GetMapping("/")
    public PageUtils<Advert> list(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                  @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        int totalCount = advertService.getTotalCount();
        List<Advert> adTypeList = advertService.getAdvertList((pageIndex - 1) * pageSize, pageSize);
        return new PageUtils<>(pageIndex, pageSize, totalCount, adTypeList);
    }

    @GetMapping("/{id}")
    public List<Advert> getByTypeId(@PathVariable Integer id) {
        return advertService.getAdvertByTypeId(id);
    }

    @PutMapping("/status")
    public int updateAdvertStatus(Integer id, Integer status) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return advertService.updateAdvertStatus(map);
    }

    @PostMapping("/")
    public int addAdvert(@RequestBody Advert advert) {
        return advertService.addAdvert(advert);
    }

    @GetMapping("/get/{id}")
    public Advert getAdvertById(@PathVariable Integer id) {
        return advertService.getAdvertById(id);
    }

    @PutMapping("/")
    public int updateAdvert(@RequestBody Advert advert) {
        return advertService.updateAdvert(advert);
    }

}