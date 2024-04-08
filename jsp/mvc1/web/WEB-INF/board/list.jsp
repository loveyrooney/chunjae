<%@ page import="java.util.List" %>
<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-08
  Time: 오후 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<EmpDTO> list = (List<EmpDTO>) request.getAttribute("list");
%>
<a href="write">글쓰기</a>
<table>
    <thead>
        <tr>
            <th>사원번호</th>
            <th>이름</th>
            <th>성</th>
            <th>급여</th>
            <th>입사일</th>
        </tr>
    </thead>
    <tbody>
        <% for(EmpDTO dto:list) {%>
            <tr>
                <td><a href="detail?id=<%=dto.getEmployee_id()%>"><%=dto.getEmployee_id()%></a></td>
                <td><%=dto.getFirst_name()%></td>
                <td><%=dto.getLast_name()%></td>
                <td><%=dto.getSalary()%></td>
                <td><%=dto.getHire_date()%></td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
