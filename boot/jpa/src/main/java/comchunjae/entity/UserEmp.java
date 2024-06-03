package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
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
}
