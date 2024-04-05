<%@ page import="dto.StudentDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-05
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>this is s2 page</p>
<%
    StudentDTO sessDTO = (StudentDTO) session.getAttribute("dto");
    out.print(sessDTO);
%>
</body>
</html>
