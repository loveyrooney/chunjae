package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardno = Integer.parseInt(req.getParameter("id"));
        BoardService service = BoardService.getService();
        service.deleteBoard(boardno);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("list");
        return forward;
    }
}
