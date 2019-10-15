package com.unicorn.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:wangsusheng
 * @Date: 2019/10/15 13:23
 */
@RestControllerAdvice  //全局异常处理切面
public class LabelExceptionHandler {
    @ExceptionHandler(value = Exception.class)  //表示拦截异常
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,  e.getMessage());
    }
}
