package com.chunjae.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString(exclude = "memberId")
@NoArgsConstructor
public class MemberDTO {
    private int memberId;
    private String name;
    private int age;
    private String addr;

    // 특정 생성자를 만들경우 기본 생성자 반드시 만들어 두기
    public MemberDTO(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
}
