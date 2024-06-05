package com.chunjae.validate.controller;

import com.chunjae.validate.dto.MemberDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HelloController {
    @GetMapping("/myform")
    public String myform(Model model){
        model.addAttribute("member",new MemberDTO());
        return "myform";
    }

    @PostMapping("/myform")
    public String myformResult(@Valid @ModelAttribute("member") MemberDTO dto,
                               BindingResult bindingResult){
        log.info("bindingResult: {}",bindingResult);
        if(bindingResult.hasErrors())
            return "myform";
        else
            return "result";
    }
}
