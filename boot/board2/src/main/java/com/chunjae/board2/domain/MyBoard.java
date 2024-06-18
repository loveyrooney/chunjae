package com.chunjae.board2.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="my_board")
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MyBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long boardId;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;
    @Column(name="write_date")
    @CreatedDate
    private LocalDateTime writeDate;
    @Column(name="update_date")
    @LastModifiedDate
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "board")
    private List<SubBoard> subList = new ArrayList<>();

    public void appendSub(SubBoard subBoard){
        subList.add(subBoard);
        subBoard.setBoard(this);
    }

    @Builder
    public MyBoard(Long boardId, String title, String content, LocalDateTime writeDate, LocalDateTime updateDate){
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
    }

}
