package com.chunjae.board.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="user_board")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)  // JPA 에서 자동으로 필드 값 채우기
public class UserBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id")
    private Long boardId;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 1000, nullable = false)
    private String content;
    @Column(length = 30)
    private String writer;
    @Column(name="write_date")
    @CreatedDate  // 자동으로 작성 날짜 생성
    private LocalDateTime writeDate;
    @Column(name="update_date")
    @LastModifiedDate  // 자동으로 수정 날짜 생성
    private LocalDateTime updateDate;
    private Float salary;

}
