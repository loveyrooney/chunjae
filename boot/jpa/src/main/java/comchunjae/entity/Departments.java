package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//@Entity
@Table(name="departments")
@Getter @Setter
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_id;
    private String department_name;
    // 해당 엔티티 기준으로 일대다 이므로, 어떤 객체로 매핑할지 지정해 준다.
    @OneToMany(mappedBy = "departments")
    private List<Employees> employees = new ArrayList<>();
}
