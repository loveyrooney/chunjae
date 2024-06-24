package com.chunjae.security.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(Model model){
        //model.addAttribute("status","403");
        return "error/403";
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public String handleNotFoundException(Model model){
        //model.addAttribute("status","404");
        return "error/403";
    }
}
