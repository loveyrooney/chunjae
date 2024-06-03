package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="employees")
@Getter @Setter
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    private String first_name;
    private String last_name;
    //private Long department_id;

    // 객체지향적 엔티티를 만들기 위해 참조관계의 테이블 객체를 가져와서 참조 컬럼을 지정해 준다.
    // 해당 엔티티 기준으로 다대일 이므로 어떤 컬럼으로 조인할지 지정해 준다.
    @ManyToOne
    @JoinColumn(name="department_id")
    private Departments departments;
}
