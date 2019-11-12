package com.yl.common.entity;

/**
 * @author yangjie
 * 2019/11/12 21:26
 */
public class Result<T> {

    private Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result(String msg, T data) {
        this.code = 500;
        this.msg = msg;
        this.data = data;
    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> ok(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> error(String msg, T data) {
        return new Result<>(msg, data);
    }

    public static <T> Result<T> build(int code, String msg, T data) {
        return new Result<>(code, msg, data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
