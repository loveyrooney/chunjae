package com.chunjae.comm;

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

@WebServlet(urlPatterns = "*.do"
        , initParams = {@WebInitParam(name="init",value="/WEB-INF/prop.properties")})
public class FrontController extends HttpServlet {
    private Map<String,Action> map = Collections.synchronizedMap(new HashMap<>());
    @Override
    public void init(ServletConfig config) throws ServletException {
        String path = config.getInitParameter("init");
        Properties prop = new Properties();
        FileReader fileReader = null;
        try{
            String realPath = config.getServletContext().getRealPath(path);
            fileReader = new FileReader(realPath);
            prop.load(fileReader);
            Enumeration enu = prop.propertyNames();
            while(enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                String value = prop.getProperty(key);
                Class router = Class.forName(value);
                Constructor c = router.getConstructor();
                Action action = (Action) c.newInstance();
                map.put(key,action);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(fileReader!=null)try{fileReader.close();}catch (Exception e){}
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
            RequestDispatcher disp = req.getRequestDispatcher(result.getUrl());
            disp.forward(req,resp);
        } else
            resp.sendRedirect(result.getUrl());
    }
}
