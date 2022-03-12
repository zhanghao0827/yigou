package com.yigou.common.entity;


import java.io.Serializable;

public class Template implements Serializable {

    private static final long serialVersionUID = -1374769570242273012L;

    private Integer id;
    private String specId;
    private String brandId;
    private String name;
    private String attribute;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", specId='" + specId + '\'' +
                ", brandId='" + brandId + '\'' +
                ", name='" + name + '\'' +
                ", attribute='" + attribute + '\'' +
                ", del=" + del +
                '}';
    }
}
