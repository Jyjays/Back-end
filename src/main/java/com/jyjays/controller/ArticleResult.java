package com.jyjays.controller;

import java.util.List;

public class ArticleResult {
    private Object data;

    private List<Object> list;

    private Object data2;
    private Integer code;
    private String msg;

    public ArticleResult() {
    }

    public ArticleResult(Object data, List<Object> list, Object data2, Integer code, String msg) {
        this.data = data;
        this.list = list;
        this.data2 = data2;
        this.code = code;
        this.msg = msg;
    }

    public ArticleResult(Object data, Integer code, String message) {
        this.data=data;
        this.code=code;
        this.msg=message;
    }
    public ArticleResult(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取
     * @return list
     */
    public List<Object> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<Object> list) {
        this.list = list;
    }

    /**
     * 获取
     * @return data2
     */
    public Object getData2() {
        return data2;
    }

    /**
     * 设置
     * @param data2
     */
    public void setData2(Object data2) {
        this.data2 = data2;
    }

    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Result{data = " + data + ", list = " + list + ", data2 = " + data2 + ", code = " + code + ", msg = " + msg + "}";
    }
}