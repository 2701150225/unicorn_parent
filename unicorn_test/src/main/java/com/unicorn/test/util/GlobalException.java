package com.unicorn.test.util;



/**
 * @Author:wangsusheng
 * @Date: 2019/11/6 10:21
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public GlobalException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GlobalException(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public GlobalException(String code) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;
    private String data;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}