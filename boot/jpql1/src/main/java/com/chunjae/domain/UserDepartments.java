package com.chunjae.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<UserEmployees> deptEmpsList = new ArrayList<>();




}
