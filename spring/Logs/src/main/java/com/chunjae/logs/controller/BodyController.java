package com.chunjae.logs.controller;

import com.chunjae.logs.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BodyController {

    // @RestController를 쓰거나, @Controller , @ResponseBody 를 쓰는 경우 리턴은 jsp 파일이 아니라 해당 객체.
    @GetMapping("/body")
    public String body(){
        return "bodyhh";
    }

    @GetMapping("/body2")
    public MemberDTO body2(){
        MemberDTO dto = new MemberDTO();
        dto.setName("hong");
        dto.setAge(10);
        return dto;
    }

    @GetMapping("/body3")
    public List<MemberDTO> body3(){
        List<MemberDTO> list = new ArrayList<>();
        list.add(new MemberDTO("kim",20));
        list.add(new MemberDTO("lee",30));
        return list;
    }
}
