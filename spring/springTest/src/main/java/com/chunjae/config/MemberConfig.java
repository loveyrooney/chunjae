package com.chunjae.config;

import com.chunjae.dto.MemberDTO;
import com.chunjae.service.MemberList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MemberConfig {
    @Bean(name="mlist")
    public MemberList createMemberList(){
        List<MemberDTO> list = new ArrayList<>();
        list.add(new MemberDTO("hong_annotation",21));
        list.add(new MemberDTO("kim_annotation",11));
        return new MemberList(list);
    }

}
