package com.chunjae.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {
    @Column(name="write_date")
    @CreatedDate  // 자동으로 작성 날짜 생성
    private LocalDateTime writeDate;
    @Column(name="update_date")
    @LastModifiedDate  // 자동으로 수정 날짜 생성
    private LocalDateTime updateDate;
}
