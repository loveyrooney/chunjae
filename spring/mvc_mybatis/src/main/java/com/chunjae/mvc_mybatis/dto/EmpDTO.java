package com.chunjae.mvc_mybatis.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmpDTO {
    private int employee_id;
    private String first_name;
    private float salary;
    private String department_name;
}
