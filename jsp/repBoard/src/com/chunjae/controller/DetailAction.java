package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("bno"));
        BoardService service = BoardService.getBoardService();
        BoardDTO dto = service.readBoard(bno);
        req.setAttribute("dto",dto);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/detailBoard.jsp");
        return forward;
    }
}
