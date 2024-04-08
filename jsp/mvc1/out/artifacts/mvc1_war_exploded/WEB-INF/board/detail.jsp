<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-08
  Time: 오후 3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    EmpDTO dto = (EmpDTO) request.getAttribute("dto");
%>
<ul>
   <% if(dto !=null) { %>
    <li>
        <%=dto.getEmployee_id()%>
        <%=dto.getFirst_name()%>
        <%=dto.getLast_name()%>
        <%=dto.getSalary()%>
        <%=dto.getHire_date()%>
    </li>
    <% } else { %>
    <li>자료가 없습니다</li>
    <% } %>
</ul>
<a href="mod?id=<%=dto.getEmployee_id()%>">수정</a>
<a href="del?id=<%=dto.getEmployee_id()%>">삭제</a>
<a href="list">목록</a>
</body>
</html>
