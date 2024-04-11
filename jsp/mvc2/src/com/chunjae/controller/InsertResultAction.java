package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class InsertResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int curr = Integer.parseInt(req.getParameter("curr"));
        int employee_id = Integer.parseInt(req.getParameter("employee_id"));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        float salary = Float.parseFloat(req.getParameter("salary"));
        LocalDate hire_date = LocalDate.parse(req.getParameter("hire_date"));
        EmpDTO dto = new EmpDTO();
        dto.setEmployee_id(employee_id);
        dto.setFirst_name(first_name);
        dto.setLast_name(last_name);
        dto.setSalary(salary);
        dto.setHire_date(hire_date);
        EmpDAO dao = EmpDAO.getInstance();
        dao.insertEmp(dto);
        req.setAttribute("dto", dto);
        req.setAttribute("curr",curr);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setPath("/WEB-INF/board/detail.jsp");
        return forward;
    }
}
