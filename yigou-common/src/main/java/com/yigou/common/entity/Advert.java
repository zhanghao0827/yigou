package com.yigou.common.entity;


import java.io.Serializable;

public class Advert implements Serializable {

    private static final long serialVersionUID = -6729553091366171383L;

    private Integer id;
    private Integer typeId;
    private String title;
    private String url;
    private String pic;
    private String status;
    private Integer sortOrder;
    private Integer del;

    //广告对应的类型
    private AdType adType;

    public AdType getAdType() {
        return adType;
    }

    public void setAdType(AdType adType) {
        this.adType = adType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pic='" + pic + '\'' +
                ", status='" + status + '\'' +
                ", sortOrder=" + sortOrder +
                ", del=" + del +
                ", adType=" + adType +
                '}';
    }
}
