package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        String content = req.getParameter("content");
        BoardDTO dto = new BoardDTO();
        dto.setTitle(title);
        dto.setWriter(writer);
        dto.setContent(content);
        BoardService service = BoardService.getService();
        service.writeBoard(dto);
        Forward forward = new Forward();
        forward.setForward(false);
        // 여기에 "/list" 를 하게 되면 http://localhost:8080/list 로 가게 된다.
        // 이 프로젝트의 기본 접근은 http://localhost:8080/myboard/ 이므로 '/'가 뒤에 붙어 있다.
        // 그래서 여기서 주소를 "list" 로만 해야 prop에 등록한 "/list" 와 같은 모양으로 완성이 된다.
        forward.setUrl("list");
        return forward;
    }
}
