package com.yigou.template.mapper;

import com.yigou.common.entity.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TemplateMapper {

    int getTotalCount(Map<String, Object> map);

    List<Template> getTemplateList(Map<String, Object> map);

    int addTemplate(Template template);

    Template getTemplateById(Integer id);

    int updateTemplate(Template template);

    List<Template> getTemplates();

}
