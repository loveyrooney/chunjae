package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//@Entity
@Getter @Setter
@Table(name="tbmember"
        , uniqueConstraints = {@UniqueConstraint(name = "uk_name", columnNames = "name")})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 엔티티의 필드들은 모두 객체가 들어가야 한다. 원시타입 x
    @Column(name="name",length = 50, nullable = false)
    //@Column(unique=true) 이렇게 쓰면 제약조건 이름을 연결하기 어려우므로 위와 같이 쓴다.
    private String name;
    private Integer age;
    @Column(length = 200)
    private String addr;
    private LocalDateTime writedate;
    @Transient // 엔티티에 있으나 테이블에는 사용하지 않는 컬럼
    private String hi;
}
