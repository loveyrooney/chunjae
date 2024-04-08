package com.chunjae.controller;

import com.chunjae.dao.EmpDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int emp_no = Integer.parseInt(req.getParameter("id"));
        EmpDAO dao = EmpDAO.getInstance();
        int result = dao.deleteData(emp_no);
//        if(result>0)
//            req.setAttribute("res",emp_no);
        return "/list";
    }
}
