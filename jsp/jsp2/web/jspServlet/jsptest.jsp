
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-02
  Time: 오후 4:34
  To change this template use File | Settings | File Templates.
--%>
<!-- page directive , 페이지 지시자. import 할 때. -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- MIME type -->
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 선언문은 %! 를 붙인다, but 잘 쓰지 않는다.
이 선언문은 jsptest.jsp 파일의 서블릿의 service 메서드 내에 쓰여지지 않고 그 밖에 선언하게 된다.
즉, jsptest.jsp 서블릿의 인스턴스 메서드가 되어버리는 것이다. (catalina_base 경로에서 만들어진 서블릿 클래스 소스 확인가능)
%!
    int add(int a,int b){
        return a+b;
    }
%
-->
<!-- 스크립트릿은 %을 붙인다.
스트립트릿 안에 선언한 변수는 jsptest.jsp 서블릿 메서드 내의 지역변수가 된다.
-->
<%
    //스크립트릿 안에서 주석은 자바에서 쓰는대로 쓰는데 이거는 서블릿 코드로 변환 되지 않는다.
    String name = "hong";
    int age = 10;
    ArrayList<String> arr = new ArrayList<>();
    arr.add("park");
    arr.add("kim");
    arr.add("lee");
    StringBuilder sb = new StringBuilder("");
    for(String i:arr){
        sb.append(i).append(", ");
    }

    out.print("in script, out.print() <br>");
    out.print("name : "+name+"<br>");
    out.print("age : "+age+"<br>");
    out.print("arr : "+sb.toString()+"<br>");

%>
<%="======================" %><br>
<!-- 표현식은 %= 을 붙인다. -->
표현식 활용 <br>
name : <%=name%><br>
age : <%=age%><br>
arr :
<% for(String i:arr) { %>
   <%=i%><br>
<% } %><br>


</body>
</html>
