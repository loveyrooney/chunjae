package com.chunjae.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="user_departments")
public class UserDepartments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long did;
    @Column(name="department_name",length = 30, nullable = false)
    private String dname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
    private UserLocations deptLoc;

    @OneToMany(mappedBy = "empDept")
    @BatchSize(size=100)
    private List<UserEmployees> deptEmpsList = new ArrayList<>();




}
