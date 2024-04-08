package com.chunjae.controller;

import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyResultAction implements Action{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int emp_no = Integer.parseInt(req.getParameter("employee_id"));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        float salary = Float.parseFloat(req.getParameter("salary"));
        String hire_date = req.getParameter("hire_date");

        EmpDTO dto = new EmpDTO();
        dto.setEmployee_id(emp_no);
        dto.setFirst_name(first_name);
        dto.setLast_name(last_name);
        dto.setSalary(salary);

        EmpDAO dao = EmpDAO.getInstance();
        dao.modifyData(dto);
        // return 값을 detail 페이지로 넘기고 싶은데 으아악 (delete 도 마찬가지)
        return "/detail";
    }
}
