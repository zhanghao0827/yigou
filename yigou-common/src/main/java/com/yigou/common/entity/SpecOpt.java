package com.yigou.common.entity;


import java.io.Serializable;

public class SpecOpt implements Serializable {

    private static final long serialVersionUID = -7211809079056121277L;

    private Integer id;
    private String optName;
    private Integer specId;
    private Integer order;
    private Integer del;

    private Spec spec;//对应规格

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "SpecOpt{" +
                "id=" + id +
                ", optName='" + optName + '\'' +
                ", specId=" + specId +
                ", order=" + order +
                ", del=" + del +
                '}';
    }
}
