package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dao.EmpDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int emp_no = Integer.parseInt(req.getParameter("id"));
        EmpDAO dao = EmpDAO.getInstance();
        // delete return 값 활용해서 list 에 파라미터 전달하는거 삽질해보기
        dao.deleteOne(emp_no);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setPath("list");
        return forward;
    }
}
