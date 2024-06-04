package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Entity
@Table(name="useremp")
@Getter @Setter
public class UserEmp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="first_name",length = 20)
    private String firstName;
    @Column(name="last_name", length = 25, nullable = false)
    private String lastName;
    @Column(length = 25,nullable = false)
    private String email;
    @Column(name="phone_number", length = 20)
    private String phoneNumber;
    @Column(name="hire_date",nullable = false)
    private LocalDate hireDate;
    @Column(precision = 8,scale = 2,nullable = false)
    private BigDecimal salary;
    @Column(name="commission_pct",precision = 2,scale = 2)
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private UserDept userDept;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="job_id")
    private UserJob userJob;

    // 셀프 조인도 ManyToOne, OneToMany 로 설정 가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")  // 이 이름으로 객체를 연결할 것이다.
    private UserEmp manager;  // 이 객체를 연결할 것이다.

    @OneToMany(mappedBy = "manager") // 이 변수명인 객체와 짝을 이루는 리스트
    private List<UserEmp> deptEmps = new ArrayList<>();

}
