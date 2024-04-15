package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        Forward forward = new Forward();
        if (id != null && pwd != null) {
            if (id.equals("aaa") && pwd.equals("123")) {
                HttpSession session = req.getSession();
                session.setAttribute("id", id);
                forward.setForward(false);
                forward.setUrl("list.do");
            } else {
                forward.setForward(false);
                forward.setUrl("login.do");
            }
        }
        return forward;
    }
}
