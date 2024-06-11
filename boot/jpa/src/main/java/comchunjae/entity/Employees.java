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

    /* RDBMS 는 테이블 간 관계, JPA 는 엔티티 간 관계
    RDBMS : 테이블 간 관계에 있어서 참조할 테이블 기본 키를 해당 테이블의 외래 키로 가져온다. (컬럼)
    JPA : 객체지향적 엔티티를 만들기 위해, 참조할 엔티티 객체 전체를 가져온다. (필드)
     @ManyToOne - 해당 엔티티 입장에서의 관계. fetchType EAGER 가 default 이다. (영속성 컨텍스트를 위한 설정)
     @JoinColumn - 참조관계의 테이블 기본키를 현재 테이블의 외래키로 가져오며, 이름은 임의로 지정할 수 있다. (db 를 위한 설정)
     ManyToOne 입장에서 Board 는 반드시 필요하지만, OneToMany 입장에서는 List<UserEmp> 가 반드시 필요한 것은 아니다.
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Departments departments;
}
