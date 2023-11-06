package com.ldy.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})//读取Controller注解的类的异常
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 拦截的异常和异常处理方法
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> addException(SQLIntegrityConstraintViolationException ex){
//        System.out.println("=================================");
//        log.error(ex.getMessage());
//        System.out.println("=================================");
        if (ex.getMessage().contains("Duplicate entry")){
            String[] strings = ex.getMessage().split(" ");
            return R.error(strings[2]+"添加失败！");
        }
        return R.error("未知错误！");
    }

}
