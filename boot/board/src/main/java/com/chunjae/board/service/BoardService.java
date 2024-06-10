package com.chunjae.board.service;

import com.chunjae.board.dto.UserBoardDTO;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<UserBoardDTO> findList();

    UserBoardDTO detail(Long boardId);

    Long insertData(UserBoardDTO dto);

    Long deleteData(Long bid);

    void updateData(UserBoardDTO dto);
}
