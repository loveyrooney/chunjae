package com.chunjae.board2.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyBoardDTO {
    private Long boardId;
    @NotEmpty(message = "제목을 입력하세요")
    @Size(min=5, message = "5자 이상 입력하세요")
    private String title;
    @NotEmpty(message = "내용을 입력하세요")
    private String content;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;

}
