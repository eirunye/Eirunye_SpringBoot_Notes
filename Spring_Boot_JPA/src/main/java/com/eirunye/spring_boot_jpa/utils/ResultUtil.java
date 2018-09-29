package com.eirunye.spring_boot_jpa.utils;

import com.eirunye.spring_boot_jpa.bean.Result;
import com.eirunye.spring_boot_jpa.enums.ResultEnum;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe
 */
public class ResultUtil {
    public static Result getResult(ResultEnum resultEnum, Object object) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(object);
        return result;
    }

    public static  Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
