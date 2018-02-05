package com.p609915198.basemodule.net;

import com.p609915198.basemodule.net.response.AdResponse;

import java.io.Serializable;

/**
 * 网络请求结果格式
 */
public class HttpResult<T> implements Serializable {
    private int code;

    private String msg;

    private T result;

    private AdResponse ad;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AdResponse getAd() {
        return ad;
    }

    public void setAd(AdResponse ad) {
        this.ad = ad;
    }
}