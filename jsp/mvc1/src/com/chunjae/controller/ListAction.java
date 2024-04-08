package com.chunjae.controller;

import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EmpDAO dao = EmpDAO.getInstance();
        List<EmpDTO> list = dao.getList();
        req.setAttribute("list",list);
        return "/WEB-INF/board/list.jsp";
    }
}
