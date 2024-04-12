package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardno = Integer.parseInt(req.getParameter("boardno"));
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writer = req.getParameter("writer");
        BoardDTO dto = new BoardDTO();
        dto.setBoardno(boardno);
        dto.setTitle(title);
        dto.setContent(content);
        dto.setWriter(writer);
        BoardService service = BoardService.getService();
        BoardDTO board = service.updateBoard(dto);
        req.setAttribute("board",board);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/detail.jsp");
        return forward;
    }
}
