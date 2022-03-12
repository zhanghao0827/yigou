package com.yigou.web.service;

import com.yigou.common.entity.Template;
import com.yigou.common.util.PageUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("yigou-template")
public interface TemplateService {

    @GetMapping("/template/")
    PageUtils<Template> getTemplateList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                        @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                        @RequestParam(defaultValue = "", required = false) String name);

    @PostMapping("/template/")
    int addTemplate(@RequestBody Template template);

    @GetMapping("/template/{id}")
    Template getTemplateById(@PathVariable Integer id);

    @PutMapping("/template/")
    int updateTemplate(@RequestBody Template template);

    @GetMapping("/template/all")
    List<Template> getTemplates();
}
