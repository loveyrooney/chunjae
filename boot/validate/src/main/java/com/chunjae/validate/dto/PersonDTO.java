package com.chunjae.validate.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private String name;
    private Integer age;
}

/*  @Data 어노테이션을 쓰지 말아야 하는 이유
    build 내의 클래스 파일을 보면 equals, hasCode, toString 등이 모두 생성되는데,
    엔티티는 has a 관계의 객체들이 서로 맞물려 있는 경우도 있기 때문에
    생성자를 사용하는 경우나 toString 에서 무한루프 가능성.
*/