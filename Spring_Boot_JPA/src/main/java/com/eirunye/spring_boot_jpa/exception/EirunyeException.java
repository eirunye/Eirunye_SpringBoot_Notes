package com.eirunye.spring_boot_jpa.exception;

import com.eirunye.spring_boot_jpa.enums.ResultEnum;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe 异常处理
 */
public class EirunyeException extends RuntimeException {

    private Integer code;

    public EirunyeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
