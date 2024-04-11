<%@ page import="com.chunjae.dto.EmpDTO" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-09
  Time: 오후 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    EmpDTO dto = (EmpDTO) request.getAttribute("dto");
    int currPage = (int) request.getAttribute("curr");
%>
<body>
<form method="post" action="upd_result">
    <input type="text" name="curr" value="<%=currPage%>" hidden><br>
    <label for="id">사원번호</label>
    <input type="text" name="employee_id" id="id" value="<%=dto.getEmployee_id()%>" readonly><br>
    <label for="f">이름</label>
    <input type="text" name="first_name" id="f" value="<%=dto.getFirst_name()%>"><br>
    <label for="l">성</label>
    <input type="text" name="last_name" id="l" value="<%=dto.getLast_name()%>"><br>
    <label for="sal">급여</label>
    <input type="text" name="salary" id="sal" value="<%=dto.getSalary()%>"><br>
    <label for="date">입사일</label>
    <input type="date" name="hire_date" id="date" value="<%=dto.getHire_date()%>"><br>
    <button type="submit">수정</button>
</form>
</body>
</html>