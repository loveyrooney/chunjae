package com.chunjae.board.service;

import com.chunjae.board.domain.UserBoard;
import com.chunjae.board.dto.UserBoardDTO;
import com.chunjae.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    @Override
    public List<UserBoardDTO> findList() {
        List<UserBoard> boardlist = boardRepository.findAll();
        List<UserBoardDTO> boardDTOList = boardlist.stream().map(item->{
            UserBoardDTO dto = new UserBoardDTO();
            dto.setBoardId(item.getBoardId());
            dto.setTitle(item.getTitle());
            dto.setContent(item.getContent());
            dto.setWriter(item.getWriter());
            dto.setWriteDate(item.getWriteDate());
            dto.setUpdateDate(item.getUpdateDate());
            dto.setSalary(item.getSalary());
            return dto;
        }).collect(Collectors.toList());
        return boardDTOList;
    }

    @Override
    public UserBoardDTO detail(Long boardId) {
        Optional<UserBoard> board = boardRepository.findById(boardId);
        UserBoardDTO boardDTO = board.stream().map(item->{
            UserBoardDTO dto = new UserBoardDTO();
            dto.setBoardId(item.getBoardId());
            dto.setTitle(item.getTitle());
            dto.setContent(item.getContent());
            dto.setWriter(item.getWriter());
            dto.setWriteDate(item.getWriteDate());
            dto.setUpdateDate(item.getUpdateDate());
            dto.setSalary(item.getSalary());
            return dto;
        }).findAny().orElseThrow(()->{
            throw new RuntimeException();
        });
        return boardDTO;
    }
}
