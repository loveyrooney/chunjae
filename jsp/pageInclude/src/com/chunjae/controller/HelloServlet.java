package com.chunjae.controller;

import com.chunjae.dto.EmpDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list.do")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }
    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<EmpDTO> list = new ArrayList<>();
        list.add(new EmpDTO(1,"hong"));
        list.add(new EmpDTO(2,"park"));
        System.out.println(list.get(0).getFirst_name());
        req.setAttribute("list",list);
        RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/board/list.jsp");
        disp.forward(req,resp);
    }
}
