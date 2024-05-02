package com.chunjae.config;

import com.chunjae.dto.MemberDTO;
import com.chunjae.dto.MemberList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanConfig2 {
    @Bean(name="ins")
    public MemberList memberList(){
        MemberList memberList = new MemberList();
        List<MemberDTO> list= new ArrayList<>();
        list.add(new MemberDTO("kim",20));
        list.add(new MemberDTO("lee",20));
        memberList.setList(list);
        return memberList;
    }
}
