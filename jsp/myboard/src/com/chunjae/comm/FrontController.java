package com.chunjae.comm;

import com.chunjae.controller.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

@WebServlet(name="FrontController", urlPatterns = "/"
            , initParams = {@WebInitParam(name="init",value = "/WEB-INF/prop.properties")})
public class FrontController extends HttpServlet {
    private Map<String, Action> map = Collections.synchronizedMap(new HashMap<>());
    @Override
    public void init(ServletConfig config) throws ServletException {
        String path = config.getInitParameter("init");
        Properties prop = new Properties();
        FileReader reader = null;
        try{
            String realPath = config.getServletContext().getRealPath(path);
            reader = new FileReader(realPath);
            prop.load(reader);
            Enumeration enu = prop.propertyNames();
            while(enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                String value = prop.getProperty(key);
                Class routerClass = Class.forName(value);
                Constructor constructor = routerClass.getConstructor();
                Action classImplementsAction = (Action) constructor.newInstance();
                map.put(key,classImplementsAction);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (reader != null) try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doReq(req,resp);
    }

    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String path = req.getServletPath();
        Action act = map.get(path);
        Forward result = act.execute(req,resp);
        if(result.isForward()){
            RequestDispatcher dispatcher = req.getRequestDispatcher(result.getUrl());
            dispatcher.forward(req,resp);
        } else {
            resp.sendRedirect(result.getUrl());
        }
    }
}
