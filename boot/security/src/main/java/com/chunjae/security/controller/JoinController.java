package com.chunjae.security.controller;

import com.chunjae.security.dto.MemberDTO;
import com.chunjae.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {
    private final MemberService memberService;
    @GetMapping("/join")
    public String joinMember(){
        return "/join";
    }

    @PostMapping("/join")
    public String joinMemberResult(MemberDTO dto){
        Long memberId = memberService.insertMember(dto);
        return "redirect:/login";
    }
}
