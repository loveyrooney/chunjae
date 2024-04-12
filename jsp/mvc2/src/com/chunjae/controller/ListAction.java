package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dao.EmpDAO;
import com.chunjae.dto.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAction implements Action {
    @Override
    public Forward execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        String input = req.getParameter("input");
        if(search == null || input == null){
            if(search == null) {
                search = "";
                input = "";
            } else {
                input = "";
            }
        }
        String curr = req.getParameter("curr");
        int currPage = 1;
        if(curr != null)
            currPage = Integer.parseInt(curr);
        int pageSize = 10;
        int startRow = (currPage-1)*pageSize;
        EmpDAO dao = EmpDAO.getInstance();
        int totalPage = (int) Math.ceil(dao.countEmp(search,input)/(float)pageSize);
        int pageListSize = 5;
        int startPage = (currPage-1)/pageListSize*pageListSize+1;
        int endPage = startPage+pageListSize-1;
        if(endPage>totalPage)
            endPage = totalPage;
        List<EmpDTO> list = dao.findEmpList(startRow,pageSize,search,input);
        // view 에 전달할 변수들을 set 한다.
        req.setAttribute("list",list);
        req.setAttribute("currPage",currPage);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("startPage",startPage);
        req.setAttribute("endPage",endPage);
        req.setAttribute("search",search);
        req.setAttribute("input",input);
        // forward 객체로 결과를 리턴한다.
        Forward f = new Forward();
        f.setForward(true);
        //f.setPath("/WEB-INF/board/list.jsp");
        f.setPath("/WEB-INF/board/list2.jsp");
        return f;
    }
}
