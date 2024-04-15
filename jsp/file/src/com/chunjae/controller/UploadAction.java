package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/main.jsp?page=uploadForm.jsp");
        return forward;
    }
}
