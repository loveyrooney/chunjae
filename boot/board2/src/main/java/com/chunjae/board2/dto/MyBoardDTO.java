package com.chunjae.board2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyBoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

}
