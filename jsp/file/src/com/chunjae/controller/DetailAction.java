package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dto.ImgDTO;
import com.chunjae.service.ImgService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("id"));
        ImgService service = ImgService.getService();
        ImgDTO board = service.findImgBoard(bno);
        req.setAttribute("board",board);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/main.jsp?page=imgBoard.jsp");
        return forward;
    }
}
