package com.caicy.pattern.adapter.passport;

import com.caicy.pattern.template.entity.User;

public class ResultMsg {
    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public ResultMsg setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ResultMsg setData(Object data) {
        this.data = data;
        return this;
    }
}
