package com.chunjae.login_upload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger("LoginController.class");
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login_result")
    public String loginresult(@RequestParam String id, @RequestParam String pwd, HttpSession session){
        if("aaa".equals(id) && "123".equals(pwd)){
            session.setAttribute("sessionId",id);
            return "redirect:/service1";
        } else
            return "redirect:/login";
    }
    // 아래 같이 로그인 권한이 필요한 모든 곳마다 적용을 할 수는 없기 때문에 인터셉터를 사용한다.
//    @GetMapping("/service1")
//    public String service1(HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        if(session==null || session.getAttribute("sessionId")==null){
//            return "redirect:/login";
//        } else {
//            return "service1";
//        }
//    }
//
//    @GetMapping("/service2")
//    public String service2(HttpServletRequest request){
//        HttpSession session = request.getSession(false);
//        if(session==null || session.getAttribute("sessionId")==null){
//            return "redirect:/login";
//        } else {
//            return "service2";
//        }
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("sessionId") != null) {
            session.invalidate();
            logger.info("session inval: {}",request.getSession());
        }
        return "redirect:/login";
    }

    @GetMapping("/service1")
    public String service1(){
        return "service1";
    }

    @GetMapping("/service2")
    public String service2(){
        return "service2";
    }
}
