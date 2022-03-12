package com.yigou.common.bean;

import java.util.Map;

public class SkuBean {

    private Integer id;
    private String title;
    private Double price;
    private Map<String, Object> spec;

    public SkuBean() {
    }

    public SkuBean(Integer id, String title, Double price, Map<String, Object> spec) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.spec = spec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Map<String, Object> getSpec() {
        return spec;
    }

    public void setSpec(Map<String, Object> spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "SkuBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", spec=" + spec +
                '}';
    }
}
