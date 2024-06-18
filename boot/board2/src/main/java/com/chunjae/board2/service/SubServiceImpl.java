package com.chunjae.board2.service;

import com.chunjae.board2.dto.SubDTO;
import com.chunjae.board2.repository.BoardRepository;
import com.chunjae.board2.repository.SubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubServiceImpl implements SubService{
    private final SubRepo subRepo;

    @Override
    public List<SubDTO> sublist(Long boardId) {
        return subRepo.findSublist(boardId);
    }
}
