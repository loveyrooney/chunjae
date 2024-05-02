package com.chunjae.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data 라는 어노테이션 사용은 지양 (생성자, toString 등 필요한 것들을 한번에 처리해주는 것인데 그냥 각각을 사용하도록)
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = "name") toString 출력 시 name 필드를 제외하고 출력
public class MemberDTO {
    private String name;
    private int age;
}
