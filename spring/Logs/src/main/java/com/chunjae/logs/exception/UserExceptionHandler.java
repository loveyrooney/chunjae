package com.chunjae.logs.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger("UserExceptionHandler.class");

    // NoFileException 이란 customException 에 관한 예외 처리 핸들러
    @ExceptionHandler(NoFileException.class)
    public String handleFoundException(NoFileException f){
        logger.info("exception... {}",f);
        return "error/userExceptionPage1";
    }
}
