package com.eirunye.spring_boot_jpa.enums;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe 返回状态处理
 */
public enum  ResultEnum {

    UNKNOWN_ERROR(-1, "UNKNOW ERROR"),//返回失败
    USERNOTEXIST(2,"USER NOT EXIST"),//用户不存在
    SUCCESS(0, "SUCCESS"), ///返回成功
    ;


    private Integer code; //返回码 0表示成功，1表示失败，-1未知错误
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
