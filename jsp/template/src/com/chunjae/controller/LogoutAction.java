package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionId = (String) session.getAttribute("id");
        if(sessionId != null)
            session.invalidate();
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("login.do");
        return forward;
    }
}
