package com.yigou.advert.controller;

import com.yigou.advert.service.AdTypeService;
import com.yigou.common.entity.AdType;
import com.yigou.common.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ad_type")
public class AdTypeController {

    @Autowired
    AdTypeService adTypeService;

    @GetMapping("/")
    public PageUtils<AdType> getAdTypeList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                           @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                           @RequestParam(defaultValue = "", required = false) String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("name", name);
        int totalCount = adTypeService.getTotalCount(map);
        List<AdType> adTypeList = adTypeService.getAdTypeList(map);
        return new PageUtils<>(pageIndex, pageSize, totalCount, adTypeList);
    }

    @PostMapping("/")
    public int addAdType(@RequestBody AdType adType) {
        return adTypeService.addAdType(adType);
    }

    @GetMapping("/{id}")
    public AdType getAdTypeById(@PathVariable Integer id) {
        return adTypeService.getAdTypeById(id);
    }

    @PutMapping("/")
    public int updateAdType(@RequestBody AdType adType) {
        return adTypeService.updateAdType(adType);
    }

    @DeleteMapping("/{id}")
    public int deleteAdTypeById(@PathVariable Integer id) {
        return adTypeService.deleteAdTypeById(id);
    }

    @GetMapping("/all")
    public List<AdType> get() {
        return adTypeService.getAdTypes();
    }

}
