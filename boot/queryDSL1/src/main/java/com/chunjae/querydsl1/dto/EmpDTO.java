package com.chunjae.querydsl1.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpDTO {
    private Long eid;
    private String firstName;
    private LocalDate hireDate;
    private Float salary;
}
