package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String seeionId = (String) session.getAttribute("id");
        Forward forward = new Forward();
        if(seeionId==null){
            forward.setForward(false);
            forward.setUrl("login.do");
        } else {
            List<EmpDTO> list = new ArrayList<>();
            list.add(new EmpDTO(1,"hong"));
            list.add(new EmpDTO(2,"park"));
            list.add(new EmpDTO(3,"kim"));
            req.setAttribute("list",list);
            forward.setForward(true);
            forward.setUrl("/WEB-INF/board/main.jsp?page=list.jsp");
        }
        return forward;
    }
}
