package com.chunjae.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/userlist")
    public String userList(){
        return "userlist";
    }
}
