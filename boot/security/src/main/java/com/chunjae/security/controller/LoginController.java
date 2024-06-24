package com.chunjae.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserDetailsService userDetailsService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

//    @PostMapping("/login")
//    public void loginResult(@RequestParam String username){
//        userDetailsService.loadUserByUsername(username);
//    }
}
