package com.chunjae.board2.repository;

import com.chunjae.board2.domain.SubBoard;
import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.dto.SubDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SubRepo {
    MyBoardDTO detail(Long boardId);
    List<SubDTO> findSublist(Long boardId);

}
