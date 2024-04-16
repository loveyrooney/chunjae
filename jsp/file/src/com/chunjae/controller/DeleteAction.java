package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.service.ImgService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bno = Integer.parseInt(req.getParameter("id"));
        String img = req.getParameter("img");
        String dir = req.getServletContext().getRealPath("upload");
        System.out.println(dir+"/"+img);
        ImgService service = ImgService.getService();
        service.deleteImgBoard(bno,dir+"/"+img);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("list.do");
        return forward;
    }
}
