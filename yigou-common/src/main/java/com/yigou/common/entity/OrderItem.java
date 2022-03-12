package com.yigou.common.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 8283151514943808869L;

    private Long id;
    private Integer itemId;
    private Integer goodsId;
    private Long orderId;
    private String title;
    private Double price;
    private Integer num;
    private Double totalFee;
    private String picPath;
    private String sellerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", goodsId=" + goodsId +
                ", orderId=" + orderId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", totalFee=" + totalFee +
                ", picPath='" + picPath + '\'' +
                ", sellerId='" + sellerId + '\'' +
                '}';
    }
}
