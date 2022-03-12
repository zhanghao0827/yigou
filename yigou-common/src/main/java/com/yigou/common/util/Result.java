package com.yigou.common.util;

public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success(String msg) {
        return new Result(200, msg, null);
    }

    public static Result success(String msg, Object obj) {
        return new Result(200, msg, obj);
    }

    public static Result error(String msg) {
        return new Result(500, msg, null);
    }

    public static Result error(Integer code,String msg) {
        return new Result(code, msg, null);
    }


    public static Result error(String msg, Object obj) {
        return new Result(500, msg, obj);
    }

    private Result() {
    }

    private Result(Integer code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }

    public Integer getcode() {
        return code;
    }

    public void setcode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
