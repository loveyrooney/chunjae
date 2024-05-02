package com.chunjae.config;

import com.chunjae.dto.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SetExam {
    @Bean
    public Set<MemberDTO> memberSet(){
        Set<MemberDTO> memberSet = new HashSet<>();
        memberSet.add(new MemberDTO("bahn",30));
        memberSet.add(new MemberDTO("lee",40));
        return memberSet;
    }
    // setTest 해 볼 것
}
