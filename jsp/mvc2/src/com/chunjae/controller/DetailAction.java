package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int emp_no = Integer.parseInt(req.getParameter("id"));
        int curr = Integer.parseInt(req.getParameter("curr"));
        EmpDAO dao = EmpDAO.getInstance();
        EmpDTO dto = dao.findOne(emp_no);
        req.setAttribute("dto",dto);
        req.setAttribute("curr",curr);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setPath("/WEB-INF/board/detail.jsp");
        return forward;
    }
}
