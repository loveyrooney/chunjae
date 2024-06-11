package com.chunjae.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name ="user_employees")
@Getter
public class UserEmployees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long eid;
    @Column(name="first_name",length = 20)
    private String firstName;
    @Column(name="hire_date",nullable = false)
    private LocalDate hireDate;
    @Column(nullable = false)
    private Float salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private UserDepartments empDept;


}
