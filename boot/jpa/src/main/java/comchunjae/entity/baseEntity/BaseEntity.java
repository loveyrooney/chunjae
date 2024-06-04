package comchunjae.entity.baseEntity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 엔티티들의 공통된 요소를 가지고 있는 클래스 (추상클래스 아니여도 됨), 엔티티가 아니므로 persist 불가
@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Integer readNo;
}
