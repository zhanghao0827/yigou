package com.yigou.common.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "goods") //索引名
public class Goods implements Serializable {

    private static final long serialVersionUID = 1890478713335006020L;

    @Field(store = true, index = false, type = FieldType.Integer)
    private Integer id;

    @Transient
    private String sellerId;

    @Field(store = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String goodsName;

    @Transient
    private Integer defaultItemId;

    @Transient
    private Integer auditStatus;

    @Transient
    private Integer isMarketable;

    @Field(store = true, index = false, type = FieldType.Integer)
    private Integer brandId;

    @Field(store = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String caption;

    @Transient
    private Integer cateMenu1Id;

    @Transient
    private Integer cateMenu2Id;

    @Transient
    private Integer cateMenu3Id;

    @Field(store = true, index = false, type = FieldType.Text)
    private String smallPic;

    @Field(store = true, index = false, type = FieldType.Double)
    private Double price;

    @Transient
    private Integer templateId;

    @Transient
    private Integer isEnableSpec;

    @Transient
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getDefaultItemId() {
        return defaultItemId;
    }

    public void setDefaultItemId(Integer defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Integer isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getCateMenu1Id() {
        return cateMenu1Id;
    }

    public void setCateMenu1Id(Integer cateMenu1Id) {
        this.cateMenu1Id = cateMenu1Id;
    }

    public Integer getCateMenu2Id() {
        return cateMenu2Id;
    }

    public void setCateMenu2Id(Integer cateMenu2Id) {
        this.cateMenu2Id = cateMenu2Id;
    }

    public Integer getCateMenu3Id() {
        return cateMenu3Id;
    }

    public void setCateMenu3Id(Integer cateMenu3Id) {
        this.cateMenu3Id = cateMenu3Id;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(Integer isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", sellerId='" + sellerId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", defaultItemId=" + defaultItemId +
                ", auditStatus=" + auditStatus +
                ", isMarketable=" + isMarketable +
                ", brandId=" + brandId +
                ", caption='" + caption + '\'' +
                ", cateMenu1Id=" + cateMenu1Id +
                ", cateMenu2Id=" + cateMenu2Id +
                ", cateMenu3Id=" + cateMenu3Id +
                ", smallPic='" + smallPic + '\'' +
                ", price=" + price +
                ", templateId=" + templateId +
                ", isEnableSpec=" + isEnableSpec +
                ", isDelete=" + isDelete +
                '}';
    }
}
