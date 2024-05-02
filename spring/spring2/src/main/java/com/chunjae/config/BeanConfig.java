package com.chunjae.config;

import com.chunjae.dto.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration // annotation 으로 빈을 등록하려고 하는 경우
public class BeanConfig {
    @Bean // <bean name="createMemberBean1" class="com.chunjae.dto.MemberDTO"/>
    public MemberDTO createMemberBean1(){
        return new MemberDTO("park",20);
    }
    @Bean // <bean name="createMemberBean2" class="com.chunjae.dto.MemberDTO" p:name="park2" p:age="22"/>
    public MemberDTO createMemberBean2(){
        MemberDTO dto = new MemberDTO();
        dto.setName("park2");
        dto.setAge(22);
        return dto;
    }
    @Bean(name="list")
    public List<String> createListBean(){
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("박지성");
        return list;
    }
}
