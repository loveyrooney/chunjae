package com.chunjae.comm;

import com.chunjae.controller.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/*
mvc 패턴 : model, view, controller 로 구성된 디자인 패턴
model : java로 작성, db연결, service 담당
view : 화면 구성
controller : servlet, client의 req, res

현재 프로젝트의 컨트롤러는 "/" 를 받는 FrontController 에서
Action interface 를 상속한 각 컨트롤러로부터 경로를 받아 jsp view 단으로 포워딩하는 투 트랙 구조
*/

@WebServlet("/")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        //System.out.println(path);
        Action act = null;
        if(path.equals("/list")){
            act = new ListAction();
        } else if(path.equals("/write")){
            act = new WriteAction();
        } else if(path.equals("/write_result")){
            act = new WriteResultAction();
        } else if(path.equals("/detail")){
            act = new DetailAction();
        } else if(path.equals("/del")){
            act = new DeleteAction();
        } else if(path.equals("/mod")){
            act = new ModifyAction();
        } else if(path.equals("/mod_result")){
            act = new ModifyResultAction();
        }

        String resultPath = act.execute(req,resp);
        RequestDispatcher disp = req.getRequestDispatcher(resultPath);
        disp.forward(req,resp);
    }
}
