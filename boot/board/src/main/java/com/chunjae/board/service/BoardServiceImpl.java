package com.chunjae.board.service;

import com.chunjae.board.domain.UserBoard;
import com.chunjae.board.dto.UserBoardDTO;
import com.chunjae.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<UserBoardDTO> findList() {
        List<UserBoard> boardlist = boardRepository.findAll();
        modelMapper.typeMap(UserBoard.class,UserBoardDTO.class)
                .addMapping(UserBoard::getWriteDate, UserBoardDTO::setCreateDate);
        List<UserBoardDTO> boardDTOList = boardlist.stream()
                .map(item->modelMapper.map(item,UserBoardDTO.class))
                .collect(Collectors.toList());
//        List<UserBoardDTO> boardDTOList = boardlist.stream().map(item->{
//            UserBoardDTO dto = new UserBoardDTO();
//            dto.setBoardId(item.getBoardId());
//            dto.setTitle(item.getTitle());
//            dto.setContent(item.getContent());
//            dto.setWriter(item.getWriter());
//            dto.setCreateDate(item.getWriteDate());
//            dto.setUpdateDate(item.getUpdateDate());
//            dto.setSalary(item.getSalary());
//            return dto;
//        }).collect(Collectors.toList());

        return boardDTOList;
    }

    @Override
    public UserBoardDTO detail(Long boardId) {
        Optional<UserBoard> board = boardRepository.findById(boardId);
        UserBoardDTO boardDTO = board.stream()
                .map(item->modelMapper.map(item,UserBoardDTO.class))
                .findAny().orElseThrow(()->{ throw new RuntimeException();});
//        UserBoardDTO boardDTO = board.stream().map(item->{
//            UserBoardDTO dto = new UserBoardDTO();
//            dto.setBoardId(item.getBoardId());
//            dto.setTitle(item.getTitle());
//            dto.setContent(item.getContent());
//            dto.setWriter(item.getWriter());
//            dto.setCreateDate(item.getWriteDate());
//            dto.setUpdateDate(item.getUpdateDate());
//            dto.setSalary(item.getSalary());
//            return dto;
//        }).findAny().orElseThrow(()->{
//            throw new RuntimeException();
//        });
        return boardDTO;
    }

    @Override
    public Long insertData(UserBoardDTO dto) {
        UserBoard user = modelMapper.map(dto,UserBoard.class);
        return boardRepository.save(user).getBoardId();
    }

    @Override
    public Long deleteData(Long bid) {
        try{
            boardRepository.deleteById(bid);
        }catch (Exception e) {
            log.info("error...{}",e);
        }
        return bid;
    }

    @Override
    @Transactional
    public void updateData(UserBoardDTO dto) {
        Optional<UserBoard> board = boardRepository.findById(dto.getBoardId());
        UserBoard target = board.orElseThrow(()->{
            throw new RuntimeException();
        });
        target.setTitle(dto.getTitle());
        target.setContent(dto.getContent());
        target.setWriter(dto.getWriter());
        target.setSalary(dto.getSalary());
    }
}
