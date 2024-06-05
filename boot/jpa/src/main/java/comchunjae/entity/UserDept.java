package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Entity
@Table(name="userdept")
@Getter @Setter
public class UserDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long departmentId;
    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id")
    private UserLoc userLoc;

    @OneToMany(mappedBy = "userDept")
    private List<UserEmp> allDeptEmps = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private UserEmp deptManager;

}
