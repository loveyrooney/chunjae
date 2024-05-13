package com.chunjae.logs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler2 {
    private static Logger logger = LoggerFactory.getLogger("UserExceptionHandler2.class");
    @ExceptionHandler(Exception.class)
    public String handlerFoundException2(Exception e){
        logger.info("UseExceptionHandler2...{}",e);
        return "/error/userExceptionPage2";
    }
}
