package com.chunjae.board2.controller;

import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* Pageable interface : 페이지 처리를 위한 인터페이스
@PageableDefault 속성에서 size, page 설정 가능, application.yml 에서도 설정가능
List 가 아닌 Page 타입으로 결과들을 받으면, 알아서 page 처리를 해 준다.
paging 처리를 하고 싶은 메서드에 pageable 객체만 추가해주면 된다.
*/

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String list(@RequestParam(name="title",required = false) String title
            , @PageableDefault(sort = "boardId", direction = Sort.Direction.ASC) Pageable pageable
            , Model model){
        if(title==null) // required false 므로 title 이 없는 경우
            title="";  // 빈 문자열은 쿼리에서는 like '%%' 으로 적용, 이것은 select * 의 결과와 같다.
        Page<MyBoardDTO> searchlist = boardService.findTitles(pageable,title);
        model.addAttribute("list", searchlist);
        return "boardlist";
    }
}
