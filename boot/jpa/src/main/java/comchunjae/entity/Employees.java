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
    // RDBMS 에서는 조인을 할 컬럼을 설정해 연결하는 방식이지만,
    //private Long department_id;

    // JPA 는 객체지향적 엔티티를 만들기 위해 참조관계의 테이블 객체를 가져와서 참조 컬럼을 지정해 준다.
    // 해당 엔티티 기준으로 다대일 관계이므로 ManyToOne, 어떤 컬럼으로 조인할지 이름을 임의로 지정해 준다.
    // ManyToOne 은 fetchType EAGER 가 default 이다.
    // ManyToOne 입장에서 Board 는 반드시 필요하지만, OneToMany 입장에서는 List<UserEmp> 가 반드시 필요한 것은 아니다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Departments departments;
}
