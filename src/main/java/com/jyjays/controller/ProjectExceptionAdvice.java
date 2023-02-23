package com.jyjays.controller;

import com.jyjays.exception.BusinessException;
import com.jyjays.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        return new Result(null,ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(null,ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex) {
        return new Result( null, Code.SYSTEM_UNKNOW_ERR,"系统繁忙，请稍后再试！");
    }
}
