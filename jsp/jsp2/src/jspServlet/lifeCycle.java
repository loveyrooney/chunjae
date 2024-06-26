package jspServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
java server page (JSP)

1. jsp 폴더구조
jsp2 (webapp 명)
src : java, servlet(웹으로 동작하는 java file)
web
   html, css, js
   META-INF
      context.xml : db 커넥션 관련
   WEB-INF
      classes : .class 파일
      lib : .jar 라이브러리 파일
      web.xml : 배치 서술자 (Deployment Descriptor)


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

@WebServlet(urlPatterns = "/jspServlet/life"
            ,initParams ={@WebInitParam(name="irum",value="hong gil dong")
                         ,@WebInitParam(name="age",value = "20")})
public class lifeCycle extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        // init 메서드에서는 ServletContext 나 ServletConfig 를 통해 초기 세팅에 필요한 것을 할 수 있다.
        ServletContext context = config.getServletContext();
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

        // config initParam 을 하나만 받아올 때
//        String name = config.getServletName();
//        String value = config.getInitParameter("irum");
//        System.out.println(name+", "+value);

        // config initParam 을 여러개 받아올 때
        Enumeration enu = config.getInitParameterNames();
        while(enu.hasMoreElements()){
            String name = (String) enu.nextElement();
            String value = config.getInitParameter(name);
            System.out.println(name+", "+value);
        }
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //System.out.println("service");
    }

    @Override
    public void destroy() {
        //System.out.println("destroy");
    }
    
}
