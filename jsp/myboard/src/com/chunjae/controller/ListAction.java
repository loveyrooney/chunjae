package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService service = BoardService.getService();
        List<BoardDTO> boardList = service.findAll();
        req.setAttribute("boardList",boardList);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/list.jsp");
        return forward;
    }
}
