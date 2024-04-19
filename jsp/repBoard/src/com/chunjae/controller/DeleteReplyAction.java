package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteReplyAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int subno = Integer.parseInt(req.getParameter("subno"));
        int bno = Integer.parseInt(req.getParameter("bno"));
        BoardService service = BoardService.getBoardService();
        service.deleteReply(subno);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("detail.do?bno="+bno);
        return forward;
    }
}
