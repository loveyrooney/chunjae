package com.chunjae.board2.service;

import com.chunjae.board2.dto.SubDTO;

import java.util.List;

public interface SubService {
    List<SubDTO> sublist(Long boardId);
    Long insertSub(SubDTO dto);
}
