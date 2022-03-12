package com.yigou.common.bean;

import java.util.List;

public class AttrBean {

    private String attrName;
    private List<String> attrValue;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<String> getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(List<String> attrValue) {
        this.attrValue = attrValue;
    }

    @Override
    public String toString() {
        return "AttrBean{" +
                "attrName='" + attrName + '\'' +
                ", attrValue=" + attrValue +
                '}';
    }
}
