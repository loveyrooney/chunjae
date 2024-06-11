package com.chunjae.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user_locations")
public class UserLocations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private Long lid;
    @Column(name="street_address",length = 40)
    private String streetAddr;
    @Column(name="postal_code",length = 12)
    private String postalCode;
    @Column(length = 30,nullable = false)
    private String city;
    @Column(name="state_province",length = 25)
    private String stateProvince;

    @OneToMany(mappedBy = "deptLoc")
    private List<UserDepartments> locDeptsList = new ArrayList<>();

}
