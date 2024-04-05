<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    if("abc".equals(id) && "123".equals(pwd)){
        session.setAttribute("id",id);
        session.setMaxInactiveInterval(100);
        response.sendRedirect("service.jsp");
    } else {
        response.sendRedirect("loginForm.jsp");
    }

%>
</body>
</html>
