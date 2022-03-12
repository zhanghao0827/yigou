package com.yigou.common.entity;


import java.io.Serializable;

public class GoodsDetail implements Serializable {

    private static final long serialVersionUID = 3800753658103748755L;

    private Integer goodsId;
    private String goodsDesc;
    private String specItem;
    private String goodsAttr;
    private String goodsImg;
    private String pkgList;
    private String saleService;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getSpecItem() {
        return specItem;
    }

    public void setSpecItem(String specItem) {
        this.specItem = specItem;
    }

    public String getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(String goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getPkgList() {
        return pkgList;
    }

    public void setPkgList(String pkgList) {
        this.pkgList = pkgList;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "goodsId=" + goodsId +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", specItem='" + specItem + '\'' +
                ", goodsAttr='" + goodsAttr + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", pkgList='" + pkgList + '\'' +
                ", saleService='" + saleService + '\'' +
                '}';
    }
}
