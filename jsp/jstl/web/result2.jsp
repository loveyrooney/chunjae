<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-11
  Time: 오전 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String[] fav = (String[]) request.getParameterValues("favorite");
%>
아이디 : ${param.id}<br>
패스워드 : ${param.pwd}<br>
이름 : ${param.name}<br>
주소 : ${param.addr}<br>
성별 : ${param.gender}<br>
좋아하는 음식 : ${paramValues.favorite[0]}, ${paramValues.favorite[1]}, ${paramValues.favorite[2]}, ${paramValues.favorite[3]}<br>
<% for(String s:fav){ %>
    <%=s%>,
<% } %>
<br>
하고싶은 말 : ${param.comment}
</body>
</html>
