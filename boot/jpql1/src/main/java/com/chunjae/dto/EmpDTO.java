package com.chunjae.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
    private Long eid;
    private String firstName;
    private LocalDate hireDate;
    private Float salary;

    public EmpDTO(String firstName, Float salary) {
        this.firstName = firstName;
        this.salary = salary;
    }
}
