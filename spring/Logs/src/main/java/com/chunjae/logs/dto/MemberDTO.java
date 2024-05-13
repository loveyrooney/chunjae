package com.chunjae.logs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberDTO {
    private String name;
    private int age;

    public MemberDTO() {
    }

    public MemberDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
