<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  session.invalidate();
  response.sendRedirect("loginForm.jsp");
%>
</body>
</html>
