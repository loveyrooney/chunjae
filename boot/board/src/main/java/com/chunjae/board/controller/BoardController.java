package com.chunjae.board.controller;

import com.chunjae.board.dto.UserBoardDTO;
import com.chunjae.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String boardlist(Model model){
        List<UserBoardDTO> list = boardService.findList();
        model.addAttribute("list",list);
        return "boardlist";
    }

    @GetMapping("/detail/{boardId}")
    public String boardDetail(@PathVariable Long boardId, Model model){
        UserBoardDTO dto = boardService.detail(boardId);
        model.addAttribute("dto",dto);
        return "detail";
    }
}
