package jspServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet(urlPatterns = "/jspServlet/mydata")
public class mydata extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer url = req.getRequestURL(); // 전체 url
        String cp = req.getContextPath(); // 프로젝트폴더
        String uri = req.getRequestURI(); // 프로젝트폴더이하경로
        int port = req.getServerPort(); // 포트번호
        String server = req.getServerName(); // 서버
        String scheme = req.getScheme(); // 프로토콜
        String sp = req.getServletPath(); // 서블릿의경로
        System.out.println(url.toString()); // http://localhost:8080/jsp2/jspServlet/mydata
        System.out.println(scheme+"://"+server+":"+port);
        System.out.println(cp); // /jsp2
        System.out.println(uri); // /jsp2/jspServlet/mydata
        System.out.println(port); // 8080
        System.out.println(scheme+"://"+server);
        System.out.println(sp); // /jspServlet/mydata

    }
}
