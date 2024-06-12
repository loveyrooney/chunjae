package com.chunjae.board2.service;

import com.chunjae.board2.dto.MyBoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    List<MyBoardDTO> findBoardList(String title);
    Page<MyBoardDTO> findTitles(Pageable pageable, String title);
    List<MyBoardDTO> findData(String title);
    int modify(Long bid);
}
