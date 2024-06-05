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

    // 해당 엔티티 기준으로 일대다 관계이므로 OneToMany, 다 쪽의 테이블에 있는 어떤 객체로 매핑할지 지정해 준다.
    // OneToMany 는 fetchType LAZY 가 default 이다.
    // OneToMany 에서 joinColumn 을 지정하는 경우, 이 엔티티에서 생기지 않고 다 쪽의 엔티티에 생기게 되므로 관리 어렵다.
    @OneToMany(mappedBy = "departments")
    private List<Employees> employees = new ArrayList<>();
}
