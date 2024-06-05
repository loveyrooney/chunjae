package com.chunjae.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBoardDTO {

    private Long boardId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;
    private Float salary;
}
