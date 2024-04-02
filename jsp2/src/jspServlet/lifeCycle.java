package jspServlet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

/*
java server page (JSP)

1. jsp 폴더구조
jsp2 (webapp 명)
src : java, servlet(웹으로 동작하는 java file)
web
   WEB-INF : 배치 서술자 (Deployment Descriptor)
   html, css, js

2. jsp -> servlet -> class
     parsing    compile

   tomcat 컨테이너는 서블릿들을 담고 있는 컨테이너이다.
   서블릿이 메모리에 있는지 확인하고 있으면 service 메서드(doGet/doPost) 호출,
   없으면 jsp 파일을 java 파일로 바꾸고 (parsing), class 로 바꾼다 (compile)
   그 후, new 해서 servlet 객체를 만들고(이때 init 메서드 실행) service 메서드를 호출한다.

3. servlet life cycle method (서블릿의 실행단계마다 호출되는 콜백 메서드)
 init : servlet 최초 실행 시, 1회 동작 (서버 동작 후 서블릿이 처음 동작할 때)
 service : 요청이 일어날 때 계속 동작 (doGet, doPost 로 동작)
 destroy : 서블릿 객체가 없어질 때 1회 동작 (서버가 종료될 때)
*/

@WebServlet(urlPatterns = "/jspServlet/life")
public class lifeCycle extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }

}
