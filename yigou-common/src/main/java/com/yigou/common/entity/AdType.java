package com.yigou.common.entity;


import java.io.Serializable;

public class AdType implements Serializable {

    private static final long serialVersionUID = 8696180211762211029L;

    private Integer id;
    private String name;
    private Integer del;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        return "AdType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", del=" + del +
                '}';
    }
}
