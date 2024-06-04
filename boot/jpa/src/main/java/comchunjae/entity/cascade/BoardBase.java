package comchunjae.entity.cascade;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BoardBase {
    // 여기서 컬럼 설정 적용해도 적용 된다.
    @Column(nullable = false)
    private String content;
    @Column(length = 50,nullable = false)
    private String writer;
    @Column(name="write_date")
    private LocalDateTime writeDate;
}
