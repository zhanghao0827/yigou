package com.yigou.template.controller;

import com.yigou.common.entity.Template;
import com.yigou.common.util.PageUtils;
import com.yigou.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @GetMapping("/")
    public PageUtils<Template> getTemplateList(@RequestParam(defaultValue = "1", required = false) Integer pageIndex,
                                               @RequestParam(defaultValue = "5", required = false) Integer pageSize,
                                               @RequestParam(defaultValue = "", required = false) String name) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("name", name);
        int totalCount = templateService.getTotalCount(map);
        List<Template> templateList = templateService.getTemplateList(map);
        return new PageUtils<>(pageIndex, pageSize, totalCount, templateList);
    }

    @PostMapping("/")
    public int addTemplate(@RequestBody Template template) {
        return templateService.addTemplate(template);
    }

    @GetMapping("/{id}")
    public Template getTemplateById(@PathVariable Integer id) {
        return templateService.getTemplateById(id);
    }

    @PutMapping("/")
    public int updateTemplate(@RequestBody Template template) {
        return templateService.updateTemplate(template);
    }

    @GetMapping("/all")
    public List<Template> getTemplates() {
        return templateService.getTemplates();
    }
}
