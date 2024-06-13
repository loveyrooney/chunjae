package com.chunjae.board2.controller;

import com.chunjae.board2.dto.MyBoardDTO;
import com.chunjae.board2.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/* Pageable interface : 페이지 처리를 위한 인터페이스
@PageableDefault 속성에서 size, page 설정 가능, application.yml 에서도 설정가능
PageRequest.of(pageNumber,pageSize,sort); 코드 추가로도 가능.
List 가 아닌 Page 타입으로 결과들을 받으면, 알아서 page 처리를 해 준다.
paging 처리를 하고 싶은 메서드에 pageable 객체만 추가해주면 된다.
*/

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String list(@RequestParam(name="title",required = false) String title
            , @PageableDefault(sort = "boardId", direction = Sort.Direction.ASC) Pageable pageable
            , Model model){
        if(title==null) // required false 므로 title 이 없는 경우
            title="";  // 빈 문자열은 쿼리에서는 like '%%' 으로 적용, 이것은 select * 의 결과와 같다.
        Page<MyBoardDTO> searchlist = boardService.findTitles(pageable,title);
        // pageable.getPageNumber() 는 현재 페이지이나, start idx 가 적용되지 않은 본래의 현재 페이지.
        log.info("currPage... {}",pageable.getPageNumber());
        // Page 객체 생성 시에 각각의 페이지 단위의 list.size()를 넣었다면 처음부터 현재까지 누적된 것을 기록,
        // 전체 리스트의 size 를 넣었다면 고정값이 된다.
        log.info("getTotalPage...{}",searchlist.getTotalPages());
        log.info("totalElement...{}",searchlist.getTotalElements());
        int pagePerBlock = 5;
        int startPage = (pageable.getPageNumber()/pagePerBlock)*pagePerBlock+1;
        int endPage = startPage+pagePerBlock-1;
        if(searchlist.getTotalPages()<endPage)
            endPage = searchlist.getTotalPages();
        log.info("startPage, endPage...{},{}",startPage,endPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("list", searchlist);
        model.addAttribute("title",title);
        return "boardlist";
    }

    @GetMapping("/detail/{boardId}")
    public String detail(@PathVariable Long boardId, Model model){
        MyBoardDTO dto = boardService.detail(boardId);
        model.addAttribute("dto",dto);
        return "detail";
    }

    @GetMapping("/write")
    public String write(Model model){
        model.addAttribute("dto",new MyBoardDTO());
        // action endpoint 를 보내서 update 인 경우와 template 을 함께 쓰고자 함.
        model.addAttribute("action","/insert");
        return "write";
    }

    @PostMapping("/insert")
    public String insertform(@Valid @ModelAttribute("dto") MyBoardDTO dto
            , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "write";
        else {
            boardService.writeNew(dto);
            return "redirect:/list";
        }
    }

    @GetMapping("/del/{boardId}")
    public ResponseEntity<String> deldata(@PathVariable Long boardId){
        boardService.deleteData(boardId);
        return ResponseEntity.status(200).body("삭제 되었습니다.");
    }

    @GetMapping("/modify/{boardId}")
    public String modify(@PathVariable Long boardId, Model model){
        MyBoardDTO dto = boardService.detail(boardId);
        model.addAttribute("dto",dto);
        model.addAttribute("action","/update/"+dto.getBoardId());
        return "write";
    }

    @PostMapping("/update/{boardId}")
    public String updateData(@PathVariable Long boardId
            , @Valid @ModelAttribute("dto") MyBoardDTO dto
            , BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "write";
        else {
            dto.setBoardId(boardId);
            boardService.updateData(dto);
            return "redirect:/detail/"+dto.getBoardId();
        }
    }
}
