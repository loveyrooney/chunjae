package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dto.ImgDTO;
import com.chunjae.service.ImgService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1024btye = 1kb, 1024kb = 1mb, 1024mb = 1gb
        int fileSize = 1024*1024*100;
        String uploadPath = req.getServletContext().getRealPath("upload");
        //System.out.println(uploadPath);
        MultipartRequest multi = new MultipartRequest(req,uploadPath,fileSize,"utf-8", new DefaultFileRenamePolicy());
        String title = multi.getParameter("title");
        String content = multi.getParameter("content");
        String file = multi.getFilesystemName("uploadfile"); // form 에서 file input 의 name
        String originalFile = multi.getOriginalFileName("uploadfile");

        ImgDTO dto = new ImgDTO();
        dto.setBtitle(title);
        dto.setBcontent(content);
        dto.setBimg(file);

        ImgService service = ImgService.getService();
        service.writeBoard(dto);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("list.do");
        return forward;
    }
}
