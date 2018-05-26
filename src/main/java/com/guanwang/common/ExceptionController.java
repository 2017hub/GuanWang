package com.guanwang.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局的异常处理类
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String exceptHand(){
       // ex.printStackTrace();
        System.out.println("------->error");
        return "error";
    }
}
