package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int curr = Integer.parseInt(req.getParameter("curr"));
        req.setAttribute("curr",curr);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setPath("/WEB-INF/board/insert.jsp");
        return forward;
    }
}
