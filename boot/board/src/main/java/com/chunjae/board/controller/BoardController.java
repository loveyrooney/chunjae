package com.chunjae.board.controller;

import com.chunjae.board.dto.UserBoardDTO;
import com.chunjae.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/myform")
    public String myform(Model model){
        model.addAttribute("board",new UserBoardDTO());
        return "myform";
    }

    @PostMapping("/myform")
    public String myformResult(@Valid @ModelAttribute("board") UserBoardDTO dto
            , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors())
            return "myform";
        else{
            Long uid = boardService.insertData(dto);
            model.addAttribute("id",uid);
            return "success";
        }
    }

    @GetMapping("/del/{bid}")
    public @ResponseBody Long deleteData(@PathVariable Long bid){
        Long result = boardService.deleteData(bid);
        return result;
    }

    @PostMapping("/mod/{bid}")
    public String updateData(@PathVariable Long bid
            , @Valid @ModelAttribute("dto") UserBoardDTO dto
            , BindingResult bindingResult){
        // @ModelAttribute 를 하는 이유는 유효성 검사 시 에러인 경우 그 결과를 보내줘야 되기 때문.
        if(bindingResult.hasErrors())
            return "detail";
        else{
            boardService.updateData(dto);
            return "redirect:/detail/"+bid;
        }
        // detail 페이지에서 에러 발생하는 경우 폼에 에러메세지는 가는데,
        // 수정 폼을 toggle을 해놔서 보이지가 않는 문제있음..
        // insert 페이지랑 혼용할 수 있는지 시도해보기
    }

}
