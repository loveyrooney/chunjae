package com.chunjae.board2.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="sub_board")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class SubBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sub_id")
    private Long subId;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private MyBoard board;

}
