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

@WebServlet(name="FrontController", urlPatterns = "/"
            ,initParams = {@WebInitParam(name = "propInit",value="/WEB-INF/props.properties")})
public class FrontController extends HttpServlet {
    // properies 에서 가져온 라우터들을 동기화된 hashMap 에 세팅한다.
    private Map<String,Action> routerSyncMap = Collections.synchronizedMap(new HashMap<>());
    @Override
    public void init(ServletConfig config) throws ServletException {
        String propInit = config.getInitParameter("propInit");
        System.out.println("initParam : "+propInit);
        // properties 파일을, hashTable 을 상속하는 properties 객체로 만들 수 있다.
        Properties properties = new Properties();
        FileReader reader = null;
        try{
            String realPath = config.getServletContext().getRealPath(propInit);
            System.out.println("initParam's realPath on Tomcat : "+realPath);
            reader = new FileReader(realPath);
            // load() 메서드 (hashTable 에서 put()에 해당) 를 통해
            // properties 파일에서 = 으로 구분된 좌항을 key 에, 우항을 value 에 세팅한다.
            properties.load(reader);
            // propertyNames() 메서드는 hashTable 에서 keySet() 과 같다.
            Enumeration enu = properties.propertyNames();
            while(enu.hasMoreElements()){
                String key = (String) enu.nextElement();
                // getProperty() 메서드는 hashTable 에서 get(Object key) 과 같다.
                String value = properties.getProperty(key);
                // properties value 를 통해 해당 라우터 클래스 Reflection
                Class routerClass = Class.forName(value);
                Constructor constructor = routerClass.getConstructor();
                Action classImplementsAction = (Action) constructor.newInstance();
                routerSyncMap.put(key,classImplementsAction);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if(reader !=null)try{reader.close();}catch (Exception e){
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
    private void doReq(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        // client 의 서블릿 경로는, routerSyncMap 의 key 가 된다.
        String path = req.getServletPath();
        // 어떤 Action 클래스로 가게 될 지 결정한다.
        Action act = routerSyncMap.get(path);
        // 해당 Acton 클래스의 결과물은 Forward 타입으로 되어 있다.
        Forward result = act.execute(req,resp);
        // forward 할 경우 dispatcher 이용해 forwarding 처리, 그렇지 않으면 sendRedirect 처리한다.
        if(result.isForward()){
            RequestDispatcher dispatcher = req.getRequestDispatcher(result.getPath());
            dispatcher.forward(req,resp);
        } else {
            resp.sendRedirect(result.getPath());
        }
    }
}
