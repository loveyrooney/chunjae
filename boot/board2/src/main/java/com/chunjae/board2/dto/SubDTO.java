package com.chunjae.board2.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubDTO {
    private Long subId;
    private String content;
    private Long boardId;
}
