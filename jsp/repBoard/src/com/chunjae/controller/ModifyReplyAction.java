package com.chunjae.controller;

import com.chunjae.comm.Forward;
import com.chunjae.dto.ReplyDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyReplyAction implements Action{
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardno = Integer.parseInt(req.getParameter("boardno"));
        int subno = Integer.parseInt(req.getParameter("subno"));
        String writer = req.getParameter("writer");
        String subcontent = req.getParameter("subcontent");
        ReplyDTO dto = new ReplyDTO();
        dto.setSubno(subno);
        dto.setWriter(writer);
        dto.setSubcontent(subcontent);
        BoardService service = BoardService.getBoardService();
        service.modifyReply(dto);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("detail.do?bno="+boardno);
        return forward;
    }
}
