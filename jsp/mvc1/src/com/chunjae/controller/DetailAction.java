package com.chunjae.controller;

import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int emp_no = Integer.parseInt(req.getParameter("id"));
        EmpDAO dao = EmpDAO.getInstance();
        EmpDTO dto = dao.detailData(emp_no);
        req.setAttribute("dto",dto);
        return "/WEB-INF/board/detail.jsp";
    }
}
