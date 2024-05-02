package com.chunjae.config;

import com.chunjae.dto.MemberDTO;
import com.chunjae.dto.Members;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import({MemberConfig.class}) // 어노테이션으로 빈 등록 설정된 컨피그레이션 클래스들
@ImportResource({"classpath:memberConfigXml.xml"}) // xml 로 설정된 빈 등록 파일들
public class IntegrationConfig {
    @Bean(name="members", initMethod = "init", destroyMethod = "destroy")
    public Members createMembers(){
        List<MemberDTO> list = new ArrayList<>();
        list.add(new MemberDTO("han",10));
        list.add(new MemberDTO("park",20));
        return new Members(list);
    }
}
