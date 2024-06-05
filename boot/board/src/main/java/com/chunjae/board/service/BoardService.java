package com.chunjae.board.service;

import com.chunjae.board.dto.UserBoardDTO;

import java.util.List;

public interface BoardService {
    List<UserBoardDTO> findList();

    UserBoardDTO detail(Long boardId);
}
