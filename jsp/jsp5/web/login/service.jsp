<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if("abc".equals(session.getAttribute("id"))){
%>
<p>서비스 화면입니다.</p>
<a href="logout.jsp">로그아웃</a>
<%
    } else
        response.sendRedirect("loginForm.jsp");
%>
</body>
</html>
