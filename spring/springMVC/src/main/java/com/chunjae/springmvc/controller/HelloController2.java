package com.chunjae.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController2 {
    @GetMapping("/res1")
    public String res1(){
        return "redirect:/pathvar/hong/123";
    }

    // url 파라미터를 변수로 받기
    @GetMapping("/pathvar/{name}/{age}")
    public String res2(@PathVariable String name, @PathVariable int age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "pathvariable";
    }
}
