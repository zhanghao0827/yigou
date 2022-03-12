package com.yigou.portal.service;

import com.yigou.common.entity.Goods;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("yigou-elasticsearch")
public interface ElasticsearchService {

    @GetMapping("/es/")
    PageUtils<Goods> page(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                 @RequestParam(defaultValue = "10", required = false) Integer pageSize,
                                 @RequestParam(defaultValue = "", required = false) String keyword);
}
