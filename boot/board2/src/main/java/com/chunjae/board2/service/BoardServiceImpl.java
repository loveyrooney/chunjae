package com.chunjae.board2.service;

import com.chunjae.board2.domain.MyBoard;
import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<MyBoardDTO> findBoardList(String title) {
        List<MyBoard> titlelist = boardRepository.findByTitleContaining(title);
        List<MyBoardDTO> list = titlelist.stream().map(item->modelMapper.map(item,MyBoardDTO.class))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Page<MyBoardDTO> findTitles(Pageable pageable, String title) {
        List<MyBoard> titlelist = boardRepository.findTitles(pageable,title);
        List<MyBoardDTO> list = new ArrayList<>();
        if(titlelist.isEmpty())
            return new PageImpl<>(list,pageable,list.size());
        list = titlelist.stream().map(item->modelMapper.map(item,MyBoardDTO.class))
                .collect(Collectors.toList());
        return new PageImpl<>(list,pageable,list.size());
    }

    @Override
    public List<MyBoardDTO> findData(String title) {
        List<Object[]> datas = boardRepository.findData(title);
        List<MyBoardDTO> result = datas.stream().map(item-> MyBoardDTO.builder()
                .boardId((Long)item[0])
                .title((String)item[1])
                .content((String) item[2])
                .build()).collect(Collectors.toList());
        return result;
    }

    @Override
    public int modify(Long bid) {
        return boardRepository.modify(bid);
    }
}
