package com.eirunye.spring_boot_jpa.handle;

import com.eirunye.spring_boot_jpa.bean.Result;
import com.eirunye.spring_boot_jpa.exception.EirunyeException;
import com.eirunye.spring_boot_jpa.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author Eirunye
 * Created by on 2018/9/29.
 * Describe
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof EirunyeException){
            EirunyeException hxExpection = (EirunyeException) e;
            return ResultUtil.error(hxExpection.getCode(),hxExpection.getMessage());
        } else {
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1,"unknow error");
        }


    }
}
