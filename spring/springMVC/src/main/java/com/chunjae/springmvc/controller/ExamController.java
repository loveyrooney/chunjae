package com.chunjae.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ExamController {
    @GetMapping("/myinfo")
    public String myinfo(){
        return "myinfo";
    }

    @PostMapping("/myresult")
    public String myresult(@RequestParam String name, @RequestParam String idnum, Model model){
        String birth = idnum.split("-")[0];
        String key = idnum.split("-")[1].substring(0,1);
        String gender;
        int age;
        if("3".equals(key) || "4".equals(key)){
            birth = "20"+birth;
            age = LocalDate.now().getYear()-Integer.parseInt(birth.substring(0,4));
            if("3".equals(key))
                gender = "남자";
            else
                gender = "여자";
        } else {
            birth = "19"+birth;
            age = LocalDate.now().getYear()-Integer.parseInt(birth.substring(0,4));
            if("1".equals(key))
                gender = "남자";
            else
                gender = "여자";
        }
        model.addAttribute("name",name);
        model.addAttribute("idnum",idnum);
        model.addAttribute("birth",birth);
        model.addAttribute("age",age);
        model.addAttribute("gender",gender);
        return "myresult";
    }
}
