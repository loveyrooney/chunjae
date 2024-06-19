package com.chunjae.board2.service;

import com.chunjae.board2.domain.MyBoard;
import com.chunjae.board2.domain.SubBoard;
import com.chunjae.board2.dto.SubDTO;
import com.chunjae.board2.repository.BoardRepository;
import com.chunjae.board2.repository.SubRepo;
import com.chunjae.board2.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubServiceImpl implements SubService{
    private final SubRepo subRepo;
    private final BoardRepository boardRepository;
    private final SubRepository subRepository;

    @Override
    public List<SubDTO> sublist(Long boardId) {
        return subRepo.findSublist(boardId);
    }

    @Override
    public Long insertSub(SubDTO dto) {
        Optional<MyBoard> board = boardRepository.findById(dto.getBoardId());
        MyBoard parent = board.orElseThrow(()->new RuntimeException());
        SubBoard newSub = SubBoard.builder()
                        .content(dto.getContent())
                        .board(parent)
                        .build();
        SubBoard result = subRepository.save(newSub);
        log.info("insert sub...{}",result.getSubId()+","+result.getBoard().getBoardId());
        return result.getSubId();
    }
}
