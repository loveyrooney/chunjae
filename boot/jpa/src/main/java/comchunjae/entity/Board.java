package comchunjae.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

//@Entity
@Table(name="board")
@Getter @Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long bid;
    private String title;
    private String content;
    private String writer;
    @Column(name="write_date")
    private LocalDateTime writedate;

    public Board(String title, String content, String writer){
        this.title=title;
        this.content=content;
        this.writer=writer;
    }
}
