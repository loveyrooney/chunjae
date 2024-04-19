package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WriteResultAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        BoardDTO dto = new BoardDTO();
        dto.setBoardtitle(title);
        dto.setBoardcontent(content);
        BoardService service = BoardService.getBoardService();
        service.writeBoard(dto);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("boardlist.do");
        return forward;
    }
}
