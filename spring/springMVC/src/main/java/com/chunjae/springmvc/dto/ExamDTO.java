package com.chunjae.springmvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExamDTO {
    private String id;
    private String pwd;
    private String name;
    private String addr;
    private String gender;
    private String[] food;
    private String comment;

}
