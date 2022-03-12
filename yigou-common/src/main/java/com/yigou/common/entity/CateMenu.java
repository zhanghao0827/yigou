package com.yigou.common.entity;


import java.io.Serializable;

public class CateMenu implements Serializable {

    private static final long serialVersionUID = -7441531778051981496L;

    private Integer id;
    private Integer parentId;
    private Integer templateId;
    private String name;
    private Integer del;

    private Template template;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "CateMenu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", templateId=" + templateId +
                ", name='" + name + '\'' +
                ", del=" + del +
                '}';
    }
}
