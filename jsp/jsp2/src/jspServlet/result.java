package jspServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = {"/jspServlet/result"})
public class result extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //request.getParameter 는 html 요소의 name 속성을 매개로, value 값을 받아온다.
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        //getParameterValues 는 value 가 여러개일 때 사용한다.
        String[] favdept = request.getParameterValues("favdept");
        String result = "";
        for(String i:favdept){
            result += i+",";
        }
        String address = request.getParameter("address");
        String comment = request.getParameter("comment");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("id: "+id+"<br>");
        out.print("pwd: "+pwd+"<br>");
        out.print("name: "+name+"<br>");
        out.print("gender: "+gender+"<br>");
        out.print("favdept: "+result+"<br>");
        out.print("address: "+address+"<br>");
        out.print("comment: "+comment+"<br>");

        //getParameterNames 는 html 요소들의 name 을 enumeration 타입으로 가져온다.
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            System.out.println(names.nextElement());
        }

    }
}
