package com.chunjae.controller;

import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class WriteResultAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int employee_id = Integer.parseInt(req.getParameter("employee_id"));
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        float salary = Float.parseFloat(req.getParameter("salary"));
        String hire_date = req.getParameter("hire_date");

//        int y = Integer.parseInt(hire_date.substring(0,4));
//        int m = Integer.parseInt(hire_date.substring(5,7));
//        int d = Integer.parseInt(hire_date.substring(8,10));
//        LocalDate now_date = LocalDate.of(y,m,d);

        EmpDTO dto = new EmpDTO();
        dto.setEmployee_id(employee_id);
        dto.setFirst_name(first_name);
        dto.setLast_name(last_name);
        dto.setSalary(salary);
        dto.setHire_date(LocalDate.parse(hire_date));

        EmpDAO dao = EmpDAO.getInstance();
        dao.insertData(dto);

        return "/list";
    }
}
