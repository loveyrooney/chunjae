package com.chunjae.comm;

import com.chunjae.controller.*;
import com.chunjae.dto.EmpDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="FrontController", urlPatterns = "*.do")
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        Action act = null;
        if(path.equals("/main.do")){
            act = new MainAction();
        } else if(path.equals("/login.do")){
            act = new LoginAction();
        } else if(path.equals("/list.do")){
            act = new ListAction();
        } else if(path.equals("/login_result.do")){
            act = new LoginResultAction();
        }else if(path.equals("/logout.do")){
            act = new LogoutAction();
        } else if(path.equals("/join.do")){
            act = new JoinAction();
        }
        Forward result = act.execute(req,resp);
        if(result.isForward()){
            RequestDispatcher disp = req.getRequestDispatcher(result.getUrl());
            disp.forward(req,resp);
        } else
            resp.sendRedirect(result.getUrl());
    }
}
