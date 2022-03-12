package com.yigou.common.entity;


import java.io.Serializable;

public class Spec implements Serializable {

    private static final long serialVersionUID = 34618030085765608L;

    private Integer id;
    private String specName;
    private Integer del;

    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "Spec{" +
                "id=" + id +
                ", specName='" + specName + '\'' +
                ", del=" + del +
                '}';
    }
}
