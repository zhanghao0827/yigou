package com.yigou.common.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class Item implements Serializable {

    private static final long serialVersionUID = 3910453957312903113L;

    private Integer id;
    private String title;
    private String sellPoint;
    private Double price;
    private Integer stockCount;
    private Integer num;
    private String barcode;
    private String image;
    private Integer cateMenuId;
    private String status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String itemSn;
    private Double costPirce;
    private Double marketPrice;
    private String isDefault;
    private Integer goodsId;
    private String sellerId;
    private String cartThumbnail;
    private String category;
    private String brand;
    private String spec;
    private String seller;


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

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCateMenuId() {
        return cateMenuId;
    }

    public void setCateMenuId(Integer cateMenuId) {
        this.cateMenuId = cateMenuId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

    public Double getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(Double costPirce) {
        this.costPirce = costPirce;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", cateMenuId=" + cateMenuId +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", itemSn='" + itemSn + '\'' +
                ", costPirce=" + costPirce +
                ", marketPrice=" + marketPrice +
                ", isDefault='" + isDefault + '\'' +
                ", goodsId=" + goodsId +
                ", sellerId='" + sellerId + '\'' +
                ", cartThumbnail='" + cartThumbnail + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", spec='" + spec + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}
