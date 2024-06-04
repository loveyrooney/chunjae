package comchunjae.entity.baseEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="your_board")
@Getter @Setter
public class YourBoard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yourBoardId;

    private String content;
    private String writer;
}
