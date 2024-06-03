package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Table(name="reply")
@Getter @Setter
public class RepBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reply_id")
    private Long rid;
    private String writer;
    private String content;
    @Column(name="write_date")
    private LocalDateTime writedate;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

}
