package com.yigou.template.service;

import com.yigou.common.entity.Template;

import java.util.List;
import java.util.Map;

public interface TemplateService {

    int getTotalCount(Map<String, Object> map);

    List<Template> getTemplateList(Map<String, Object> map);

    int addTemplate(Template template);

    Template getTemplateById(Integer id);

    int updateTemplate(Template template);

    List<Template> getTemplates();
}
