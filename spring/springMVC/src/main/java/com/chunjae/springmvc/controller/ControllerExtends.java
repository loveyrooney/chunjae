package com.chunjae.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 레거시 방식에서는 이렇게 했었다. 상속받을 수 있는 컨트롤러의 종류 매우 많음.
// jsp 에서 properties - frontController 방식을 취할 수 있는 건 SimpleUrlController
public class ControllerExtends extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","홍길동");
        mav.addObject("addr","서울");
        mav.addObject("age",10);
        mav.addObject("comment","안녕하세요");
        mav.setViewName("mav"); // 연결할 jsp 파일 이름
        return mav;
    }
}
