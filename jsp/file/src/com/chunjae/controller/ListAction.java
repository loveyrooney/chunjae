package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dto.ImgDTO;
import com.chunjae.service.ImgService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImgService service = ImgService.getService();
        List<ImgDTO> list = service.findImgList();
        //System.out.println(list.size());
        req.setAttribute("list",list);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/main.jsp?page=imgList.jsp");
        return forward;
    }
}
