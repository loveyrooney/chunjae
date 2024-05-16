package com.chunjae.spring8.controller;

import com.chunjae.spring8.dto.UserDeptDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello2")
    public UserDeptDTO hello2(){
        UserDeptDTO dto = new UserDeptDTO(1,"HR");
        return dto;
    }

    @GetMapping("/hello3")
    public List<UserDeptDTO> hello3(){
        List<UserDeptDTO> list = new ArrayList<>();
        list.add(new UserDeptDTO(2,"Development"));
        list.add(new UserDeptDTO(3,"executive"));
        return list;
    }

}
