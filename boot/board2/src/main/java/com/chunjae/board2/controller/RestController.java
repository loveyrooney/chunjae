package com.chunjae.board2.controller;

import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {
    private final BoardService boardService;
    @GetMapping("/myboard")
    public MyBoardDTO selectB(@RequestParam Long bid){
        MyBoardDTO dto = boardService.detail(bid);
        return dto;
    }

    @PostMapping("/myboard")
    public MyBoardDTO insertB(@RequestBody MyBoardDTO dto){
        boardService.writeNew(dto);
        MyBoardDTO result = boardService.findData(dto.getTitle()).get(0);
        return result;
    }

//    @PutMapping("/myboard")
//    public String updateB(){}
//
//    @DeleteMapping("/myboard")
//    public String deleteB(){}
}
