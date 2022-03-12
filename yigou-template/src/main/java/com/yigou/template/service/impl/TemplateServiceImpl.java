package com.yigou.template.service.impl;

import com.yigou.common.entity.Template;
import com.yigou.common.util.JsonUtils;
import com.yigou.template.mapper.TemplateMapper;
import com.yigou.template.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateMapper templateMapper;


    @Override
    public int getTotalCount(Map<String, Object> map) {
        return templateMapper.getTotalCount(map);
    }

    @Override
    public List<Template> getTemplateList(Map<String, Object> map) {
        List<Template> templateList = templateMapper.getTemplateList(map);
        for (Template template : templateList) {
            String s1 = JsonUtils.parseJson(template.getBrandId());
            template.setBrandId(s1);
            String s2 = JsonUtils.parseJson(template.getSpecId());
            template.setSpecId(s2);
            String s3 = JsonUtils.parseJson(template.getAttribute());
            template.setAttribute(s3);
        }
        return templateList;
    }

    @Override
    public int addTemplate(Template template) {
        return templateMapper.addTemplate(template);
    }

    @Override
    public Template getTemplateById(Integer id) {
        return templateMapper.getTemplateById(id);
    }

    @Override
    public int updateTemplate(Template template) {
        return templateMapper.updateTemplate(template);
    }

    @Override
    public List<Template> getTemplates() {
        return templateMapper.getTemplates();
    }

}
