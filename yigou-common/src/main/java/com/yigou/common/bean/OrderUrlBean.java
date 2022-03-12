package com.yigou.common.bean;

public class OrderUrlBean {

    private Integer order;
    private String url;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OrderUrlBean{" +
                "order=" + order +
                ", url='" + url + '\'' +
                '}';
    }
}
